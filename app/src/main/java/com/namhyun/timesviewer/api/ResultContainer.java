package com.namhyun.timesviewer.api;

/**
 * Created by Namhyun, Gu on 2015-01-05.
 */
public class ResultContainer {
    private String mTitle;
    private String mAbstract;
    private String mUrl;
    private String mMultimediaUrl;

    /**
     * ResultContainer Constructor
     *
     * @param mTitle Title
     * @param mAbstract Abstract
     * @param mUrl Url
     * @param mMultimediaUrl MultimediaUrl
     */
    public ResultContainer(String mTitle, String mAbstract, String mUrl, String mMultimediaUrl) {
        this.mTitle = mTitle;
        this.mAbstract = mAbstract;
        this.mUrl = mUrl;
        this.mMultimediaUrl = mMultimediaUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAbstract() {
        return mAbstract;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getMultimediaUrl() {
        return mMultimediaUrl;
    }
}
