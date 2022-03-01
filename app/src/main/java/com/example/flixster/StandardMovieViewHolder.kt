package com.example.flixster

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StandardMovieViewHolder(v: View, context: Context) :  RecyclerView.ViewHolder(v) {
    private val ivMovieImage = itemView.findViewById<ImageView>(R.id.ivMovieImage)
    private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)
    private val contextCurr = context

    fun bind(movie: Movie) {
        tvTitle.text = movie.title
        tvOverview.text = movie.overview
        Glide.with(contextCurr).load(movie.movieImageUrl).placeholder(R.drawable.placeholder).into(ivMovieImage)
    }
}