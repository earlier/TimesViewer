package com.namhyun.timesviewer.api;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Namhyun, Gu on 2015-01-05.
 */
public class NewsWire {
    /**
     * Define format type
     */
    private final String PARAM_FORMATS = ".json";

    /**
     * Define parameter api key
     */
    private final String PARAM_API_KEY = "api-key";

     /**
     * Built Uri instance
     *
     * @return Uri
     */
    public Uri getUri() {
        return Uri.parse(Config.API_BASE_URL).buildUpon()
                .appendPath(Config.API_VERSION)
                .appendPath("content")
                .appendPath(Config.API_DEFAULT_SOURCE)
                .appendPath(Config.API_DEFAULT_SECTION)
                .appendPath(PARAM_FORMATS)
                .appendQueryParameter(PARAM_API_KEY, Config.API_KEY).build();
    }

    /**
     * Build Uri instance (custom paramter)
     *
     * @param source  Source parameter (all / nyt / iht)
     * @param section Section paramter
     * @return Uri
     */
    public Uri getUri(String source, String section) {
        return Uri.parse(Config.API_BASE_URL).buildUpon()
                .appendPath(Config.API_VERSION)
                .appendPath("content")
                .appendPath(source)
                .appendPath(section)
                .appendPath(PARAM_FORMATS)
                .appendQueryParameter(PARAM_API_KEY, Config.API_KEY).build();
    }

    /**
     * Get reuslt from json data
     *
     * @param jsonStr Json data
     * @return ResultContainer List
     */
    public List<ResultContainer> getResults(String jsonStr) {
        List<ResultContainer> results = new ArrayList<ResultContainer>();
        try {
            final String NEWSWIRE_RESULTS = "results";
            final String NEWSWIRE_TITLE = "title";
            final String NEWSWIRE_ABSTRACT = "abstract";
            final String NEWSWIRE_URL = "url";
            final String NEWSWIRE_MULTIMEDIA = "multimedia";
            final String NEWSWIRE_MULTIMEDIA_URL = "url";

            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray resultsArray = jsonObject.getJSONArray(NEWSWIRE_RESULTS);
            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject resultObject = resultsArray.getJSONObject(i);
                String titleStr = resultObject.getString(NEWSWIRE_TITLE);
                String abstractStr = resultObject.getString(NEWSWIRE_ABSTRACT);
                String urlStr = resultObject.getString(NEWSWIRE_URL);

                if(!resultObject.getString(NEWSWIRE_MULTIMEDIA).equals("")) {
                    JSONArray multimediaArray = resultObject.getJSONArray(NEWSWIRE_MULTIMEDIA);
                    JSONObject multimediaObject = multimediaArray.getJSONObject(0);
                    String multimediaUrlStr = multimediaObject.getString(NEWSWIRE_MULTIMEDIA_URL);
                    results.add(new ResultContainer(titleStr, abstractStr, urlStr, multimediaUrlStr));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return results;
        }
    }
}
