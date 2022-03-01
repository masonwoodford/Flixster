package com.example.flixster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

private const val STANDARD = 0
private const val POPULAR = 1

class MovieAdapter(private val context: Context, private val movies: List<Movie>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)

        val viewHolder = if (viewType == STANDARD) {
            val standardView: View = inflater.inflate(R.layout.item_movie, viewGroup, false)
            StandardMovieViewHolder(standardView, context)
        } else {
            val popularView: View = inflater.inflate(R.layout.item_movie_popular, viewGroup, false)
            PopularMovieViewHolder(popularView, context)
        }

        return viewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return if (movies[position].rating > 8) POPULAR else STANDARD
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = movies[position]
        if (holder.itemViewType == POPULAR) {
            val vhPopular = holder as PopularMovieViewHolder
            vhPopular.bind(movie)
        } else {
            val vhStandard = holder as StandardMovieViewHolder
            vhStandard.bind(movie)
        }
    }
    override fun getItemCount() = movies.size

}
