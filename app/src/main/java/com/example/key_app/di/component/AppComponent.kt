package com.example.key_app.di.component

import android.app.Application
import com.example.key_app.App
import com.example.key_app.di.AppModule
import com.example.key_app.di.RepositoryModule
import com.example.key_app.di.module.ViewModelModule
import com.example.key_app.di.builder.CarListFragmentBuilder
import com.example.key_app.di.builder.MainActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    RepositoryModule::class,
    ViewModelModule::class,
    MainActivityBuilder::class,
    CarListFragmentBuilder::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)
}