package com.example.flixster

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StandardMovieViewHolder(v: View, context: Context, movies: List<Movie>) :  RecyclerView.ViewHolder(v), View.OnClickListener {
    private val ivMovieImage = itemView.findViewById<ImageView>(R.id.ivMovieImage)
    private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)
    private val contextCurr = context
    private val movies = movies

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(movie: Movie) {
        tvTitle.text = movie.title
        tvOverview.text = movie.overview
        Glide.with(contextCurr).load(movie.movieImageUrl).placeholder(R.drawable.placeholder).into(ivMovieImage)
    }

    override fun onClick(v2: View?) {
        val movie = movies[adapterPosition]
        val intent = Intent(contextCurr, DetailActivity::class.java)
        intent.putExtra(MOVIE_EXTRA, movie)
        contextCurr.startActivity(intent)
    }
}