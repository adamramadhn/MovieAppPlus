package com.adam.movieapp.detail

import androidx.lifecycle.ViewModel
import com.adam.movieapp.core.domain.model.Movie
import com.adam.movieapp.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteTourism(movie: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}

