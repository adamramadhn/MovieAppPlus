package com.adam.movieapp.di

import com.adam.movieapp.core.domain.usecase.MovieInteractor
import com.adam.movieapp.core.domain.usecase.MovieUseCase
import com.adam.movieapp.detail.DetailMovieViewModel
import com.adam.movieapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}