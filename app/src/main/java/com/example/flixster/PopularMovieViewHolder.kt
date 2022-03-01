package com.example.flixster

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PopularMovieViewHolder (v: View, context: Context) :  RecyclerView.ViewHolder(v) {
    private val ivMovieImage = itemView.findViewById<ImageView>(R.id.ivBackdrop)
    private val context_curr = context

    fun bind(movie: Movie) {
        Glide.with(context_curr).load(movie.movieImageUrl).placeholder(R.drawable.placeholder).into(ivMovieImage)
    }
}