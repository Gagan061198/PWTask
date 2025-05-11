package com.example.template.data.api

import com.example.template.data.model.AnimeDetailResponse
import com.example.template.data.model.AnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface JikanApiService {
    @GET("v4/top/anime")
    suspend fun getTopAnime(): AnimeListResponse

    @GET("v4/anime/{id}")
    suspend fun getAnimeDetails(@Path("id") animeId: Int): AnimeDetailResponse
} 