package com.lynd.mvisample.ui.main

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lynd.mvisample.R
import com.lynd.mvisample.base.BaseActivity
import com.lynd.mvisample.entity.MovieData
import com.lynd.mvisample.entity.PageData
import com.lynd.mvisample.state.BaseState
import com.lynd.mvisample.ui.adpter.MovieAdapter
import kotlinx.coroutines.*

class MainActivity : BaseActivity<MainPresenter>(), MainView {

	private lateinit var mRv: RecyclerView
	private lateinit var mTvInfo: TextView

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		mRv = getView<RecyclerView>(R.id.rv).apply {
			layoutManager = GridLayoutManager(this@MainActivity, 2)
			addItemDecoration(object : RecyclerView.ItemDecoration() {
				override fun getItemOffsets(
					outRect: Rect,
					view: View,
					parent: RecyclerView,
					state: RecyclerView.State
				) {
					outRect.set(5, 5, 5, 5)
				}
			})
		}
		mTvInfo = getView(R.id.info_tv)
		mPresenter.getMovie(1)
	}

	override fun initPresenter(): MainPresenter = MainPresenter(this)

	override fun layoutId(): Int = R.layout.activity_main
	override fun loadData(movies: PageData<MovieData>) {
		setAdapter(movies)
	}

	private fun setInfo(text: String) {
		if (mTvInfo.visibility == View.GONE) {
			mTvInfo.visibility = View.VISIBLE
			mRv.visibility = View.GONE
		}
		mTvInfo.text = text
	}

	private fun setAdapter(
		movies: PageData<MovieData>
	) {
		if (mRv.visibility == View.GONE) {
			mRv.visibility = View.VISIBLE
			mTvInfo.visibility = View.GONE
		}
		mRv.adapter = MovieAdapter(movies.results)
	}

	override fun updateUI(s: BaseState) {
		when (s) {
			is BaseState.OnLoading -> setInfo("数据加载中")
			is BaseState.FinishLoadingState -> setInfo("数据加载完成")
		}
	}

}