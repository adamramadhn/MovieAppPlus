package com.adam.movieapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.adam.movieapp.core.data.source.local.entity.MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun tourismDao(): com.adam.movieapp.core.data.source.local.room.MovieDao
}