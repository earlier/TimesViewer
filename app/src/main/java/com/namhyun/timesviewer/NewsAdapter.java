package com.namhyun.timesviewer;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.namhyun.timesviewer.api.ResultContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015-01-05.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<ResultContainer> mResultContainerList;
    private Activity mActivity;

    public NewsAdapter(Activity mActivity) {
        mResultContainerList = new ArrayList<ResultContainer>();
        this.mActivity = mActivity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View mItemView = null;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
        }

        /**
         * Get view object
         *
         * @return Item view
         */
        public View getView() {
            return mItemView;
        }
    }

    /**
     * Add item
     *
     * @param container ResultContainer Object
     */
    public void addItem(ResultContainer container) {
        mResultContainerList.add(container);
        notifyDataSetChanged();
    }

    /**
     * Remove index item
     *
     * @param index
     */
    public void removeItem(int index) {
        mResultContainerList.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        View itemView = holder.getView();
        ResultContainer container = mResultContainerList.get(position);

        TextView contentPrimary = (TextView) itemView.findViewById(R.id.content_primary);
        TextView contentSecondary = (TextView) itemView.findViewById(R.id.content_secondary);
        ImageView contentImage = (ImageView) itemView.findViewById(R.id.content_image);

        contentPrimary.setText(container.getTitle());
        contentSecondary.setText(container.getAbstract());

        Glide.with(mActivity).load(container.getMultimediaUrl())
                .centerCrop()
                .crossFade()
                .into(contentImage);
    }

    @Override
    public int getItemCount() {
        return mResultContainerList.size();
    }


}
