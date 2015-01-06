package com.namhyun.timesviewer;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.namhyun.timesviewer.api.NewsWire;
import com.namhyun.timesviewer.api.ResultContainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Namhyun, Gu on 2015-01-05.
 */
public class NewsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private NewsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NewsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.content_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new NewsAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        updateNews();
        return rootView;
    }

    private void updateNews() {
        new NewsUpdateTask().execute();
    }

    private class NewsUpdateTask extends AsyncTask<String, Void, List<ResultContainer>> {

        @Override
        protected List<ResultContainer> doInBackground(String... params) {
            List<ResultContainer> results = null;
            String jsonStr;
            Uri uri = null;
            try {
                // Create NewsWire Instance
                NewsWire newsWire = new NewsWire();

                if (params.length == 0)
                    uri = newsWire.getUri();
                else
                    uri = newsWire.getUri(params[0], params[1]);

                URL url = new URL(uri.toString());
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    jsonStr = null;
                }
                String line;
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = reader.readLine()) != null)
                    buffer.append(line + "\n");

                if (buffer.length() == 0) {
                    jsonStr = null;
                    return null;
                }
                jsonStr = buffer.toString();
                results = newsWire.getResults(jsonStr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return results;
        }

        @Override
        protected void onPostExecute(List<ResultContainer> resultContainers) {
            super.onPostExecute(resultContainers);
            if (resultContainers != null) {
                for (ResultContainer container : resultContainers)
                    mAdapter.addItem(container);
            }
        }
    }
}
