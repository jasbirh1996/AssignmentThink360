package com.jb.moviethink360.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jb.moviethink360.data.remote.model.Search
import com.jb.moviethink360.databinding.MovieItemBinding
import com.squareup.picasso.Picasso

class MovieAdapter(var list: List<Search>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position),position)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (data : Search,pos : Int){
            binding.apply {
                Picasso.get().load(data.Poster).into(ivPoster)
                tvMovieName.text = data.Title
                tvDate.text = data.Year

            }
        }


    }
}