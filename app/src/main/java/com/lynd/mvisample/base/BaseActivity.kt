package com.lynd.mvisample.base

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T : BasePresenter> : AppCompatActivity() {

	lateinit var mPresenter: T

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		mPresenter = initPresenter()
		setContentView(layoutId())
	}

	fun <T : View> getView(@IdRes id: Int): T = findViewById(id)
	abstract fun initPresenter(): T

	@LayoutRes
	abstract fun layoutId(): Int
}