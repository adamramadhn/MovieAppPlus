package com.adam.movieapp.core.data.source.local

import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: com.adam.movieapp.core.data.source.local.room.MovieDao) {

    fun getAllTourism(): Flow<List<com.adam.movieapp.core.data.source.local.entity.MovieEntity>> = movieDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<com.adam.movieapp.core.data.source.local.entity.MovieEntity>> = movieDao.getFavoriteTourism()

    suspend fun insertTourism(movieList: List<com.adam.movieapp.core.data.source.local.entity.MovieEntity>) = movieDao.insertTourism(movieList)

    fun setFavoriteTourism(movie: com.adam.movieapp.core.data.source.local.entity.MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteTourism(movie)
    }
}