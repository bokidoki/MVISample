package com.lynd.mvisample.entity

data class PageData<T>(
	val dates: TIMDBDate,
	val page: Int,
	val results: List<MovieData>,
	val total_pages: Int,
	val total_results: Int,
)

data class TIMDBDate(
	val maximum: String,
	val minimum: String
)