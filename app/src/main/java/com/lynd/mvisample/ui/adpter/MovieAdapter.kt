package com.lynd.mvisample.ui.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lynd.mvisample.R
import com.lynd.mvisample.constants.IMAGE_DOMAIN
import com.lynd.mvisample.entity.MovieData

class MovieAdapter(private val list: List<MovieData>) : RecyclerView.Adapter<MovieHolder>() {
	override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieHolder =
		MovieHolder(LayoutInflater.from(p0.context).inflate(R.layout.rv_item, p0, false))

	override fun onBindViewHolder(p0: MovieHolder, p1: Int) {
		p0.bindData(list[p1])
	}

	override fun getItemCount(): Int = list.size
}

class MovieHolder(private val view: View) : RecyclerView.ViewHolder(view) {
	private val ivCover = view.findViewById<ImageView>(R.id.iv_cov)
	private val tvTitle = view.findViewById<TextView>(R.id.tv_title)
	private val tvVote = view.findViewById<TextView>(R.id.tv_vote)
	private val tvReleaseDate = view.findViewById<TextView>(R.id.tv_release_date)
	private val tvOverview = view.findViewById<TextView>(R.id.tv_overview)

	fun bindData(data: MovieData) {
		Glide.with(view.context).load(IMAGE_DOMAIN + data.poster_path).into(ivCover)
		tvTitle.text = data.title
		tvVote.text = "${data.vote_average}"
		tvReleaseDate.text = data.release_date
		tvOverview.text = "描述: ${data.overview}"
	}

}