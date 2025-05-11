package com.example.template.di

import com.example.template.data.api.JikanApiService
import com.example.template.data.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAnimeRepository(apiService: JikanApiService): AnimeRepository {
        return AnimeRepository(apiService)
    }
} 