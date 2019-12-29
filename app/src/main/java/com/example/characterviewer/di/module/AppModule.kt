package com.example.characterviewer.di.module

import App
import dagger.Module
import dagger.Provides

@Module
class AppModule(app: App) {
    private val mApplication = app
    @Provides
    fun provideApplication(): App{
        return mApplication
    }
}