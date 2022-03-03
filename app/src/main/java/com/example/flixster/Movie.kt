package com.example.flixster

import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.json.JSONArray

private const val TAG = "MOVIE"

@Parcelize
data class Movie(
    val movieId: Int,
    private val imagePath: String,
    val title: String,
    val overview: String,
    val rating: Double
    ) : Parcelable {
    @IgnoredOnParcel
    val movieImageUrl = "https://image.tmdb.org/t/p/w342/$imagePath"
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray, orientation: Int): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                val rating = movieJson.getDouble("vote_average")
                Log.i(TAG, rating.toString())
                val imagePath = if (orientation != 1 || rating > 8) {
                    movieJson.getString("backdrop_path")
                } else {
                    movieJson.getString("poster_path")
                }
                movieJson.getString("poster_path")
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        imagePath,
                        movieJson.getString("title"),
                        movieJson.getString("overview"),
                        movieJson.getDouble("vote_average")
                    )
                )
            }
            return movies
        }
    }
}