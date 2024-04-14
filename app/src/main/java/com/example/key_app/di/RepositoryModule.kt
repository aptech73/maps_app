package com.example.key_app.di

import android.content.Context
import com.example.key_app.data.CarRepositoryImpl
import com.example.key_app.domain.repository.CarRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCarRepository(context: Context) : CarRepository = CarRepositoryImpl(context)
}