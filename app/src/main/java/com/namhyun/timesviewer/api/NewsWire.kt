package com.namhyun.timesviewer.api

import android.net.Uri
import org.json.JSONException
import org.json.JSONObject
import java.util.*

object NewsWire {
    /**
     * Define format type
     */
    private val PARAM_FORMATS = ".json"

    /**
     * Define parameter api key
     */
    private val PARAM_API_KEY = "api-key"

    /**
     * Built Uri instance

     * @return Uri
     */
    fun getUri(): Uri {
        return Uri.parse(Config.API_BASE_URL).buildUpon()
                .appendPath(Config.API_VERSION)
                .appendPath("content")
                .appendPath(Config.API_DEFAULT_SOURCE)
                .appendPath(Config.API_DEFAULT_SECTION)
                .appendPath(PARAM_FORMATS)
                .appendQueryParameter(PARAM_API_KEY, Config.API_KEY).build()
    }

    /**
     * Built Uri instance (custom parameter)

     * @param source  Source parameter (all / nyt / iht)
     * *
     * @param section Section paramter
     * *
     * @return Uri
     */
    fun getUri(source: String, section: String): Uri {
        return Uri.parse(Config.API_BASE_URL).buildUpon()
                .appendPath(Config.API_VERSION)
                .appendPath("content")
                .appendPath(source)
                .appendPath(section)
                .appendPath(PARAM_FORMATS)
                .appendQueryParameter(PARAM_API_KEY, Config.API_KEY).build()
    }

    /**
     * Get reuslt from json data

     * @param jsonStr Json data
     * *
     * @return News List
     */
    fun parse(jsonStr: String): List<News> {
        val results = ArrayList<News>()
        try {
            val NEWSWIRE_RESULTS = "results"
            val NEWSWIRE_TITLE = "title"
            val NEWSWIRE_ABSTRACT = "abstract"
            val NEWSWIRE_URL = "url"
            val NEWSWIRE_MULTIMEDIA = "multimedia"
            val NEWSWIRE_MULTIMEDIA_URL = "url"

            val jsonObject = JSONObject(jsonStr)
            val resultsArray = jsonObject.getJSONArray(NEWSWIRE_RESULTS)
            for (i in 0..resultsArray.length() - 1) {
                val resultObject = resultsArray.getJSONObject(i)
                val titleStr = resultObject.getString(NEWSWIRE_TITLE)
                val abstractStr = resultObject.getString(NEWSWIRE_ABSTRACT)
                val urlStr = resultObject.getString(NEWSWIRE_URL)

                if (resultObject.getString(NEWSWIRE_MULTIMEDIA) != "") {
                    val multimediaArray = resultObject.getJSONArray(NEWSWIRE_MULTIMEDIA)
                    val multimediaObject = multimediaArray.getJSONObject(0)
                    val multimediaUrlStr = multimediaObject.getString(NEWSWIRE_MULTIMEDIA_URL)
                    results.add(News(titleStr, abstractStr, urlStr, multimediaUrlStr))
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        } finally {
            return results
        }
    }
}
