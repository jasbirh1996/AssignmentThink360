package com.jb.moviethink360.data.remote.network

import com.jb.moviethink360.data.remote.model.Think360DataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/")
    suspend fun getData(
        @Query("s")s :String,
        @Query("apikey")apikey : String
    ): Response<Think360DataResponse>
}