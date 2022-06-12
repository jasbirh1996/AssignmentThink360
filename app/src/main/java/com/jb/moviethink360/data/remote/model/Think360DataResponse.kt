package com.jb.moviethink360.data.remote.model

data class Think360DataResponse(
    val Response: String,
    val Search: List<Search>?,
    val totalResults: String
)