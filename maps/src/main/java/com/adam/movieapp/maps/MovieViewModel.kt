package com.adam.movieapp.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.adam.movieapp.core.domain.usecase.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}