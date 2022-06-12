package com.jb.moviethink360.ui

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jb.moviethink360.data.remote.model.Think360DataResponse
import com.jb.moviethink360.data.remote.network.NetworkResult
import com.jb.moviethink360.data.remote.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class  MovieViewModel @Inject constructor(val repo : MovieRepository) : ViewModel() {
    var movieData : MutableLiveData<NetworkResult<Think360DataResponse>> = MutableLiveData()

    fun invokeApi(searchString : String){
        viewModelScope.launch (Dispatchers.IO){
            if(searchString.isNotEmpty()){
                val response = repo.getMovies(searchString)
                try {
                    movieData.postValue(NetworkResult.Success(response))

                }catch (e: Exception){
                    Log.e("exception:" ,e.message.toString())
                }
            }

        }

    }




}