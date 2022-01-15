package com.lynd.mvisample.net

import com.lynd.mvisample.constants.API_LEVEL
import com.lynd.mvisample.constants.IN_THEATERS_PATH
import com.lynd.mvisample.entity.MovieData
import com.lynd.mvisample.entity.PageData
import retrofit2.http.GET
import retrofit2.http.Query

interface DouBanService {

    @GET("${API_LEVEL}${IN_THEATERS_PATH}")
    suspend fun getMovieInTheaters(
        @Query("tag") tag: String,
        @Query("page_limit") page_limit: Int,
        @Query("page_start") page_start: Int
    ): PageData<MovieData>
}