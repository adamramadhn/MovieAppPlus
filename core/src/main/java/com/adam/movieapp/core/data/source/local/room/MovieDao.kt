package com.adam.movieapp.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM tourism")
    fun getAllTourism(): Flow<List<com.adam.movieapp.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM tourism where isFavorite = 1")
    fun getFavoriteTourism(): Flow<List<com.adam.movieapp.core.data.source.local.entity.MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourism(movie: List<com.adam.movieapp.core.data.source.local.entity.MovieEntity>)

    @Update
    fun updateFavoriteTourism(movie: com.adam.movieapp.core.data.source.local.entity.MovieEntity)
}
