package com.lynd.mvisample.ui.main

import com.lynd.mvisample.base.BaseView
import com.lynd.mvisample.entity.MovieData
import com.lynd.mvisample.entity.PageData

interface MainView : BaseView {

	fun loadData(movies: PageData<MovieData>)
}