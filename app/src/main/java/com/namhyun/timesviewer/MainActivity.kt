package com.namhyun.timesviewer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.namhyun.timesviewer.api.NewsWire
import com.namhyun.timesviewer.extensions.showToast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        adapter = NewsAdapter(this)

        content_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
            setHasFixedSize(true)
        }

        loadNews()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun loadNews() {
        val request = Request.Builder()
                .url(NewsWire.getUri().toString())
                .build()

        val client = OkHttpClient()

        doAsync {
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                uiThread { this@MainActivity.showToast("Unexpected code $response") }
                return@doAsync
            }

            response.let {
                val newsList = NewsWire.parse(it.body()?.string()!!)
                uiThread {
                    adapter.clearItems()
                    adapter.addItems(newsList)
                }
            }
        }
    }
}
