package com.adam.movieapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.adam.movieapp.R
import com.adam.movieapp.core.domain.model.Movie
import com.adam.movieapp.databinding.ActivityDetailMovieBinding
import com.bumptech.glide.Glide
import org.koin.android.BuildConfig
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMovieViewModel: DetailMovieViewModel by viewModel()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.detail_movie_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val detailTourism = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailMovie: Movie?) {
        val link = "https://image.tmdb.org/t/p/w500"

        detailMovie?.let {
           binding.apply {
               this.content.tvTitle.text = it.title
               this.content.tvRelease.text = it.release_date
               this.content.tvRating.text = it.vote_average.toString()
               val img = "$link/${it.poster_path}"
               this.content.tvDetailDescription.text = detailMovie.description
               Glide.with(this@DetailMovieActivity)
                   .load(img)
                   .into(this.content.ivDetailImage)

               var statusFavorite = detailMovie.isFavorite
               setStatusFavorite(statusFavorite)
               this.content.fab.setOnClickListener {
                   statusFavorite = !statusFavorite
                   detailMovieViewModel.setFavoriteTourism(detailMovie, statusFavorite)
                   setStatusFavorite(statusFavorite)
               }
           }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.content.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.content.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }
}
