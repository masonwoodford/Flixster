package com.example.flixster

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PopularMovieViewHolder (v: View, private val context: Context, private val movies: List<Movie>) :  RecyclerView.ViewHolder(v), View.OnClickListener {
    private val ivMovieImage = itemView.findViewById<ImageView>(R.id.ivBackdrop)

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(movie: Movie) {
        Glide.with(context).load(movie.movieImageUrl).placeholder(R.drawable.placeholder).into(ivMovieImage)
    }

    override fun onClick(v2: View?) {
        val movie = movies[adapterPosition]
        val intent = Intent(context, DetailActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, ivMovieImage, "movie_image")
        intent.putExtra(MOVIE_EXTRA, movie)
        context.startActivity(intent)
    }


}