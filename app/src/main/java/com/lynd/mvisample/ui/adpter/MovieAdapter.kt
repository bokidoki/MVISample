package com.lynd.mvisample.ui.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lynd.mvisample.R
import com.lynd.mvisample.entity.MovieData

class MovieAdapter(val list: List<MovieData>) : RecyclerView.Adapter<MovieHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieHolder =
        MovieHolder(LayoutInflater.from(p0.context).inflate(R.layout.rv_item, null, false))

    override fun onBindViewHolder(p0: MovieHolder, p1: Int) {
        p0.bindData(list[p1])
    }

    override fun getItemCount(): Int = list.size
}

class MovieHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val ivCover = view.findViewById<ImageView>(R.id.iv_cov)
    private val tvTitle = view.findViewById<TextView>(R.id.tv_title)

    fun bindData(data: MovieData) {
        Glide.with(view.context).load(data.cover).into(ivCover)
        tvTitle.text = data.title
    }

}