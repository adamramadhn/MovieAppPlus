package com.adam.movieapp.core.di

import androidx.room.Room
import com.adam.movieapp.core.data.source.remote.network.ApiService
import com.adam.movieapp.core.domain.repository.IMovieRepository
import com.adam.movieapp.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<com.adam.movieapp.core.data.source.local.room.MovieDatabase>().tourismDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            com.adam.movieapp.core.data.source.local.room.MovieDatabase::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { com.adam.movieapp.core.data.source.local.LocalDataSource(get()) }
    single { com.adam.movieapp.core.data.source.remote.RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMovieRepository> {
        com.adam.movieapp.core.data.MovieRepository(
            get(),
            get(),
            get()
        )
    }
}