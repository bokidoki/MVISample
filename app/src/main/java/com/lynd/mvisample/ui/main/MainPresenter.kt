package com.lynd.mvisample.ui.main

import com.lynd.mvisample.base.BasePresenter
import com.lynd.mvisample.state.BaseState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(private val v: MainView) : BasePresenter() {

	fun getMovie(page: Int) {
		v.updateUI(BaseState.OnLoading)
		CoroutineScope(Dispatchers.IO).launch {
			val data = mNetClient.getMovieInTheaters(page = page)
			withContext(Dispatchers.Main) {
				v.updateUI(BaseState.FinishLoadingState)
				v.loadData(data)
			}
		}
	}
}