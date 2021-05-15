package com.adam.movieapp.core.domain.repository

import com.adam.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllTourism(): Flow<com.adam.movieapp.core.data.Resource<List<Movie>>>

    fun getFavoriteTourism(): Flow<List<Movie>>

    fun setFavoriteTourism(movie: Movie, state: Boolean)

}