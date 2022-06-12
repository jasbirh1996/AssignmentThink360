package com.jb.moviethink360.data.remote.repository

import com.jb.moviethink360.data.remote.model.Think360DataResponse
import com.jb.moviethink360.data.remote.network.Api
import retrofit2.Response
import javax.inject.Inject


class MovieRepository @Inject constructor(val api : Api)  {

    suspend fun getMovies(s : String): Think360DataResponse{
        return  api.getData(s,"a0783fa9").body()!!
    }

}