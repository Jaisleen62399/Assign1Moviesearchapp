package com.jaisleen.moviesearchapp.data.repository

import android.util.Log
import com.google.gson.Gson
import com.jaisleen.moviesearchapp.data.model.Movie
import com.jaisleen.moviesearchapp.data.model.MovieDetails
import com.jaisleen.moviesearchapp.data.model.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class MovieRepository {
   private val client = OkHttpClient()
   private val gson = Gson()
   private val apiKey = "1e267f96"

   suspend fun searchMovies(query: String): List<Movie>? = withContext(Dispatchers.IO) {
      val url = "https://www.omdbapi.com/?apikey=$apiKey&s=$query"
      val request = Request.Builder().url(url).build()
      val response = client.newCall(request).execute()
      val body = response.body?.string()

      val result = gson.fromJson(body, MovieResponse::class.java)

      return@withContext if (result.Response == "True") {
         result.Search
      } else {
         Log.e("OMDB_API", "Search Error: ${result.Error}")
         null
      }
   }

   suspend fun getMovieDetails(imdbID: String): MovieDetails? = withContext(Dispatchers.IO) {
      val url = "https://www.omdbapi.com/?apikey=$apiKey&i=$imdbID"
      val request = Request.Builder().url(url).build()
      val response = client.newCall(request).execute()
      val body = response.body?.string()

      val result = gson.fromJson(body, MovieDetails::class.java)
      return@withContext result
   }
}
