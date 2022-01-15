package com.lynd.mvisample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lynd.mvisample.net.NetClient
import com.lynd.mvisample.ui.adpter.MovieAdapter
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        MainScope().launch {
            val movies = NetClient.getInstance().getDouBanService().getMovieInTheaters("热门", 10, 0)
            withContext(Dispatchers.Main) {
                rv.adapter = MovieAdapter(movies.subjects)
            }
        }
    }
}