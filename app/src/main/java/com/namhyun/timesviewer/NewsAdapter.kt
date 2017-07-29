package com.namhyun.timesviewer

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.namhyun.timesviewer.api.News
import com.namhyun.timesviewer.extensions.load
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by Namhyun, Gu on 2015-01-05.
 */
class NewsAdapter(val activity: Activity) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    val newsList: MutableList<News> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun addItems(container: List<News>) {
        newsList.addAll(container)
        notifyDataSetChanged()
    }

    fun clearItems() {
        newsList.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(news: News) {
            with(itemView) {
                tv_title.text = news.title
                tv_abstract.text = news.abstract
                iv_news_image.load(activity, news.multimediaUrl)

                setOnClickListener {
                    val uri = Uri.parse(news.url)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    if (intent.resolveActivity(activity.packageManager) != null) {
                        activity.startActivity(intent)
                    }
                }
            }
        }
    }
}
