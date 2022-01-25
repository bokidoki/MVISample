package com.lynd.mvisample.base

import com.lynd.mvisample.net.NetClient

abstract class BasePresenter {

	val mNetClient = NetClient.getInstance().getMovieService()
}