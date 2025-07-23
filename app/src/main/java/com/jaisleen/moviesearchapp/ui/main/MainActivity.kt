package com.jaisleen.moviesearchapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jaisleen.moviesearchapp.databinding.ActivityMainBinding
import com.jaisleen.moviesearchapp.ui.details.MovieDetailsActivity
import com.jaisleen.moviesearchapp.viewmodel.MovieViewModel


class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding
   private val viewModel: MovieViewModel by viewModels()
   private lateinit var adapter: MovieAdapter

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)

      adapter = MovieAdapter { movie ->
         val intent = Intent(this, MovieDetailsActivity::class.java)
         intent.putExtra("MOVIE_ID", movie.imdbID)
         startActivity(intent)
      }
      binding.recyclerView.adapter = adapter

      binding.btnSearch.setOnClickListener {
         val query = binding.editTextSearch.text.toString()
         if (query.isNotEmpty()) {
            viewModel.searchMovies(query)
         }
      }

      viewModel.movieList.observe(this) {
         adapter.submitList(it)
      }
   }
}
