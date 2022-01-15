package com.lynd.mvisample.entity

data class MovieData(
    val cover: String,
    val cover_x: Int,
    val cover_y: Int,
    val id: String,
    val is_new: Boolean,
    val playable: Boolean,
    val rate: String,
    val title: String,
    val url: String
)