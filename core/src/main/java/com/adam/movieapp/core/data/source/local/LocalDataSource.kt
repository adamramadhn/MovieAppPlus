package com.adam.movieapp.core.data.source.local

import com.adam.movieapp.core.data.source.local.entity.MovieEntity
import com.adam.movieapp.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllTourism(): Flow<List<MovieEntity>> =
        movieDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<MovieEntity>> =
        movieDao.getFavoriteTourism()

    suspend fun insertTourism(movieList: List<MovieEntity>) =
        movieDao.insertTourism(movieList)

    fun setFavoriteTourism(
        movie: MovieEntity,
        newState: Boolean
    ) {
        movie.isFavorite = newState
        movieDao.updateFavoriteTourism(movie)
    }
}