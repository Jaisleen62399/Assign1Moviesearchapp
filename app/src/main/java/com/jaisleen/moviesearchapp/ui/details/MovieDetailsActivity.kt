package com.jaisleen.moviesearchapp.ui.details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jaisleen.moviesearchapp.databinding.ActivityMovieDetailsBinding
import com.jaisleen.moviesearchapp.viewmodel.MovieViewModel

class MovieDetailsActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMovieDetailsBinding
   private val viewModel: MovieViewModel by viewModels()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
      setContentView(binding.root)

      val movieId = intent.getStringExtra("MOVIE_ID") ?: return
      viewModel.getMovieDetails(movieId)

      viewModel.selectedMovie.observe(this) { movieDetails ->
         binding.title.text = movieDetails.Title
         binding.description.text = movieDetails.Plot
         binding.director.text = "Director: ${movieDetails.Director}"
         binding.year.text = "Year: ${movieDetails.Year}"
         Glide.with(this).load(movieDetails.Poster).into(binding.poster)
      }

      binding.btnBack.setOnClickListener { finish() }
   }
}
