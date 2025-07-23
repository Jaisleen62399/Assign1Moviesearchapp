package com.jaisleen.moviesearchapp.data.repository

import com.jaisleen.moviesearchapp.data.model.Movie
import com.jaisleen.moviesearchapp.data.model.MovieDetails
import com.jaisleen.moviesearchapp.data.model.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson

class MovieRepository {
   private val client = OkHttpClient()
   private val gson = Gson()
   private val apiKey = "1e267f96"

   // 🔍 Search movies by keyword
   suspend fun searchMovies(query: String): List<Movie>? = withContext(Dispatchers.IO) {
      val url = "https://www.omdbapi.com/?apikey=$apiKey&s=$query"
      val request = Request.Builder().url(url).build()
      val response = client.newCall(request).execute()
      val body = response.body?.string()
      gson.fromJson(body, MovieResponse::class.java).Search
   }

   // 📄 Get details of a specific movie by imdbID
   suspend fun getMovieDetails(imdbID: String): MovieDetails? = withContext(Dispatchers.IO) {
      val url = "https://www.omdbapi.com/?apikey=$apiKey&i=$imdbID"
      val request = Request.Builder().url(url).build()
      val response = client.newCall(request).execute()
      val body = response.body?.string()
      gson.fromJson(body, MovieDetails::class.java)
   }
}
