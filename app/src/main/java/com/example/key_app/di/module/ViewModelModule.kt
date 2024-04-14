package com.example.key_app.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.key_app.di.module.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}