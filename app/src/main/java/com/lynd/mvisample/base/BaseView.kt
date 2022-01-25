package com.lynd.mvisample.base

import com.lynd.mvisample.state.BaseState

interface BaseView {

	fun updateUI(s: BaseState)
}