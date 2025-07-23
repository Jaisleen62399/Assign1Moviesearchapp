package com.jaisleen.moviesearchapp.data.model

data class MovieResponse(
   val Search: List<Movie>?,  // List of movies returned by the search
   val totalResults: String?, // Total number of results found
   val Response: String?      // Response status ("True" or "False")
)
