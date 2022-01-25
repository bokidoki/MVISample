package com.lynd.mvisample.net

import com.lynd.mvisample.constants.API_LEVEL
import com.lynd.mvisample.constants.NOW_PLAYING
import com.lynd.mvisample.entity.MovieData
import com.lynd.mvisample.entity.PageData
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBMovieService {

	@GET("${API_LEVEL}${NOW_PLAYING}")
	suspend fun getMovieInTheaters(
		@Query("language") language: String = "en-US",
		@Query("page") page: Int,
		@Query("region") region: String = ""
	): PageData<MovieData>
}