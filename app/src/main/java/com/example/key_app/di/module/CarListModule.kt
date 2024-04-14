package com.example.key_app.di.module

import androidx.lifecycle.ViewModel
import com.example.key_app.ui.screen.SharedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CarListModule {
    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel::class)
    fun bindSharedViewModel(sharedViewModel: SharedViewModel) : ViewModel
}