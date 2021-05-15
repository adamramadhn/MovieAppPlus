package com.adam.movieapp

import android.app.Application
import com.adam.movieapp.core.di.databaseModule
import com.adam.movieapp.core.di.networkModule
import com.adam.movieapp.core.di.repositoryModule
import com.adam.movieapp.di.useCaseModule
import com.adam.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}