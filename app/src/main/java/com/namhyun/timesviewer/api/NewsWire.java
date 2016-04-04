package com.namhyun.timesviewer.api;

import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

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
     * Built Uri instance (custom paramter)
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

    /**
     * Get result from json data
     * @deprecated This method is not stable
     *
     * @param jsonStr Json data
     * @return ResultContainer List
     */
    public List<ResultContainer> getResultsUsesGson(String jsonStr){
        List<ResultContainer> results = new ArrayList<ResultContainer>();
        Gson gson = new Gson();
        GsonContainer gsonContainer =  gson.fromJson(jsonStr, GsonContainer.class);
        for(GsonContainer.Result container : gsonContainer.getResults()){
            String titleStr = container.getTitle();
            String abstractStr = container.getAbstract();
            String urlStr = container.getUrl();

            // TODO : Some results multimedia field is empty. It was occurred exception
            // TODO : Exception Content) IllegalStateException: Expected BEGIN_ARRAY but was STRING
            String multimediaUrlStr = container.getMultimedia().get(0).getUrl();
            results.add(new ResultContainer(titleStr, abstractStr, urlStr, multimediaUrlStr));
        }
        return results;
    }

    /**
     *
     *
     * @param param
     * @return
     */
    private int test(int param){
        return param;
    }

    /**
     * Gson POJO Class
     *
     * class GsonContainer
     * class GsonContainer.Result
     * class Multimedia
     */
    public class GsonContainer{
        private List<Result> results;

        public List<Result> getResults() {
            return results;
        }

        public class Result {
            private String title;

            @SerializedName("abstract")
            private String abstractStr;

            private String url;

            private List<Multimedia> multimedia;

            public String getTitle() {
                return title;
            }

            public String getAbstract(){
                return abstractStr;
            }

            public String getUrl() {
                return url;
            }

            public List<Multimedia> getMultimedia() {
                return multimedia;
            }
        }
    }

    public class Multimedia {
        private String url;

        public String getUrl() {
            return url;
        }
    }
}
