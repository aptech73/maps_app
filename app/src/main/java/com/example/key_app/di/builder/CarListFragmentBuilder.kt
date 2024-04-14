package com.example.key_app.di.builder

import com.example.key_app.di.module.CarListModule
import com.example.key_app.ui.screen.CarListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CarListFragmentBuilder {
    @ContributesAndroidInjector(modules = [CarListModule::class])
    fun contributeCarListFragment() : CarListFragment
}