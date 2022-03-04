package com.example.flixster

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.core.util.Pair
import com.bumptech.glide.Glide

class StandardMovieViewHolder(v: View, private val context: Context, private val movies: List<Movie>) :  RecyclerView.ViewHolder(v), View.OnClickListener {
    private val ivMovieImage = itemView.findViewById<ImageView>(R.id.ivMovieImage)
    private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(movie: Movie) {
        tvTitle.text = movie.title
        tvOverview.text = movie.overview
        Glide.with(context).load(movie.movieImageUrl).placeholder(R.drawable.placeholder).into(ivMovieImage)
    }

    override fun onClick(v2: View?) {
        val movie = movies[adapterPosition]
        val intent = Intent(context, DetailActivity::class.java)
        val vMovieImage = itemView.findViewById<ImageView>(R.id.ivMovieImage) as View
        val vTitle = itemView.findViewById<ImageView>(R.id.tvTitle) as View
        val vOverview = itemView.findViewById<ImageView>(R.id.tvOverview) as View
        val titlePair = Pair(vTitle, "movie_title")
        val overviewPair = Pair(vOverview, "movie_overview")
        val imagePair = Pair(vMovieImage, "movie_image")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, titlePair, overviewPair, imagePair)
        intent.putExtra(MOVIE_EXTRA, movie)
        context.startActivity(intent, options.toBundle())
    }
}