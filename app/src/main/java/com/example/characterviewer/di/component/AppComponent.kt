package com.example.characterviewer.di.component

import App
import com.example.characterviewer.di.module.AppModule
import com.example.characterviewer.di.module.NetworkModule
import com.example.characterviewer.viewmodel.DataRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface AppComponent {
    fun inject(app: App)
    fun getDataRepository(): DataRepository
}