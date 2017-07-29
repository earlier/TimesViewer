package com.namhyun.timesviewer.extensions

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.load(context: Context, url: String) {
    Picasso.with(context).load(url).into(this)
}