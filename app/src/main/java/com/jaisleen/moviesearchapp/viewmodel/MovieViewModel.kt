package com.jaisleen.moviesearchapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaisleen.moviesearchapp.data.model.Movie
import com.jaisleen.moviesearchapp.data.model.MovieDetails
import com.jaisleen.moviesearchapp.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
   private val repository = MovieRepository()
   val movieList = MutableLiveData<List<Movie>>()
   val selectedMovie = MutableLiveData<MovieDetails>()

   fun searchMovies(query: String) {
      viewModelScope.launch {
         movieList.value = repository.searchMovies(query)
      }
   }

   fun getMovieDetails(id: String) {
      viewModelScope.launch {
         selectedMovie.value = repository.getMovieDetails(id)
      }
   }
}
