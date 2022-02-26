package com.example.flixster

import org.json.JSONArray

data class Movie(
    val movieId: Int,
    private val imagePath: String,
    val title: String,
    val overview: String)
{
    val movieImageUrl = "https://image.tmdb.org/t/p/w342/$imagePath"
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray, orientation: Int): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                val imagePath = if (orientation == 1) movieJson.getString("poster_path") else movieJson.getString("backdrop_path")
                movieJson.getString("poster_path")
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        imagePath,
                        movieJson.getString("title"),
                        movieJson.getString("overview"),
                    )
                )
            }
            return movies
        }
    }
}