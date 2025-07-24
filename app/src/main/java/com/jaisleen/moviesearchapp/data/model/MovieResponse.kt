package com.jaisleen.moviesearchapp.data.model

data class MovieResponse(
   val Search: List<Movie>?,
   val totalResults: String?,
   val Response: String,
   val Error: String? = null
)
