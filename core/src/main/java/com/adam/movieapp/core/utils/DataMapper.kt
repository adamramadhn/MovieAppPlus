package com.adam.movieapp.core.utils

import com.adam.movieapp.core.data.source.local.entity.MovieEntity
import com.adam.movieapp.core.data.source.remote.response.MovieResponse
import com.adam.movieapp.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val tourismList = ArrayList<MovieEntity>()
        input.map {
            val tourism = MovieEntity(
                tourismId = it.id,
                title = it.title,
                description = it.overview,
                poster_path = it.poster_path,
                release_date = it.release_date,
                vote_average = it.vote_average,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                tourismId = it.tourismId,
                title = it.title,
                description = it.description,
                poster_path = it.poster_path,
                release_date = it.release_date,
                vote_average = it.vote_average,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) =
        MovieEntity(
            tourismId = input.tourismId,
            title = input.title,
            description = input.description,
            poster_path = input.poster_path,
            release_date = input.release_date,
            vote_average = input.vote_average,
            isFavorite = input.isFavorite
        )
}