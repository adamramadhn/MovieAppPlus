package com.adam.movieapp.core.utils

import com.adam.movieapp.core.data.source.remote.response.MovieResponse
import com.adam.movieapp.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<com.adam.movieapp.core.data.source.local.entity.MovieEntity> {
        val tourismList = ArrayList<com.adam.movieapp.core.data.source.local.entity.MovieEntity>()
        input.map {
            val tourism = com.adam.movieapp.core.data.source.local.entity.MovieEntity(
                tourismId = it.id,
                title = it.title,
                description = it.overview,
                poster_path = it.poster_path,
                release_date = it.release_date,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<com.adam.movieapp.core.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                tourismId = it.tourismId,
                title = it.title,
                description = it.description,
                poster_path = it.poster_path,
                release_date = it.release_date,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) =
        com.adam.movieapp.core.data.source.local.entity.MovieEntity(
            tourismId = input.tourismId,
            title = input.title,
            description = input.description,
            poster_path = input.poster_path,
            release_date = input.release_date,
            isFavorite = input.isFavorite
        )
}