package com.adam.movieapp.core.domain.usecase

import com.adam.movieapp.core.domain.model.Movie
import com.adam.movieapp.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie() = movieRepository.getAllTourism()

    override fun getFavoriteMovie() = movieRepository.getFavoriteTourism()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) = movieRepository.setFavoriteTourism(movie, state)
}