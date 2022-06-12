package com.jb.moviethink360

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.jb.moviethink360.data.remote.network.NetworkResult
import com.jb.moviethink360.databinding.ActivityMainBinding
import com.jb.moviethink360.ui.MovieViewModel
import com.jb.moviethink360.ui.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Error

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.cvSearch.setOnClickListener {
            viewModel.invokeApi(binding.etSearch.text.toString().trim())
        }
        viewModel.movieData.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {


                    if (response.data?.Search == null) {
                        Toast.makeText(this@MainActivity, "invalid input", Toast.LENGTH_LONG).show()


                    } else {
                        binding.apply {

                            rvMovies.apply {
                                layoutManager = GridLayoutManager(context, 3)
                                adapter = MovieAdapter(response.data?.Search!!)
                            }

                        }
                    }


                }
                is NetworkResult.Error -> {
                    Log.e("error", response.message.toString())
                    Toast.makeText(
                        this@MainActivity,
                        response.message.toString(),
                        Toast.LENGTH_LONG
                    ).show()


                }
                is NetworkResult.Loading -> {
                    Log.e("loading: ", "Loading....")
                }
            }

        }


    }
}