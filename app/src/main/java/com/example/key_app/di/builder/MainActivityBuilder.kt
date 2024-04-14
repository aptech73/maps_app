package com.example.key_app.di.builder

import com.example.key_app.di.module.MainModule
import com.example.key_app.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityBuilder {
    @ContributesAndroidInjector(modules = [MainModule::class])
    fun contributeMainActivity(): MainActivity
}