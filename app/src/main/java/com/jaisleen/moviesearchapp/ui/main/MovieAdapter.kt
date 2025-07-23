package com.jaisleen.moviesearchapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jaisleen.moviesearchapp.data.model.Movie
import com.jaisleen.moviesearchapp.databinding.ItemMovieBinding

class MovieAdapter(private val onItemClick: (Movie) -> Unit)
   : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffCallback()) {

   class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
      val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return MovieViewHolder(binding)
   }

   override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
      val movie = getItem(position)
      holder.binding.apply {
         title.text = movie.Title
         year.text = movie.Year
         studio.text = movie.Type
         rating.text = "IMDB ID: ${movie.imdbID}"
         Glide.with(poster.context).load(movie.Poster).into(poster)
         root.setOnClickListener { onItemClick(movie) }
      }
   }
}

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
   override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
      return oldItem.imdbID == newItem.imdbID
   }

   override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
      return oldItem == newItem
   }
}
