package com.lynd.mvisample.net

import com.lynd.mvisample.constants.API_KEY
import com.lynd.mvisample.constants.DOMAIN
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetClient private constructor() {

	private val okhttp: OkHttpClient = OkHttpClient.Builder()
		.addInterceptor {
			val req = it.request()
			val urlBuilder = req.url.newBuilder()
			urlBuilder.addQueryParameter("api_key", API_KEY)
			val newReq = Request.Builder().url(urlBuilder.build()).build()
			it.proceed(newReq)
		}
		.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
		.build()

	private val retrofit = Retrofit.Builder()
		.client(okhttp)
		.baseUrl(DOMAIN)
		.addConverterFactory(GsonConverterFactory.create())
		.build()

	companion object {
		private var client: NetClient? = null

		@Synchronized
		fun getInstance(): NetClient {
			if (client == null) {
				client = NetClient()
			}
			return client!!
		}
	}

	fun getMovieService(): TMDBMovieService =
      retrofit.create(TMDBMovieService::class.java)
}