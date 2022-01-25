package com.lynd.mvisample.state

import com.lynd.mvisample.entity.MovieData
import com.lynd.mvisample.entity.PageData

sealed class MainState : BaseState() {

	class SuccessState(movies: PageData<MovieData>) : MainState()
}