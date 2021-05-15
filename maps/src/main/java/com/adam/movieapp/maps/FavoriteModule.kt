package com.adam.movieapp.maps

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { MovieViewModel(get()) }
}