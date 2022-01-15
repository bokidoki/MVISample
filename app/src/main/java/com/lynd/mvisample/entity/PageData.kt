package com.lynd.mvisample.entity

data class PageData<T>(
    val count: Int,
    val start: Int,
    val subjects: List<T>,
    val title: String,
    val total: Int
)