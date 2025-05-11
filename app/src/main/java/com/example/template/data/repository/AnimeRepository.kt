package com.example.template.data.repository

import com.example.template.data.api.JikanApiService
import com.example.template.data.model.AnimeDetail
import com.example.template.data.model.AnimeListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimeRepository(private val apiService: JikanApiService) {
    suspend fun getTopAnime(): List<AnimeListItem> = withContext(Dispatchers.IO) {
        try {
            apiService.getTopAnime().data
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getAnimeDetails(animeId: Int): AnimeDetail? = withContext(Dispatchers.IO) {
        try {
            apiService.getAnimeDetails(animeId).data
        } catch (e: Exception) {
            null
        }
    }
} 