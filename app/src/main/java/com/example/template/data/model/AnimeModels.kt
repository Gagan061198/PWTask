package com.example.template.data.model

data class AnimeListResponse(
    val data: List<AnimeListItem>,
    val pagination: Pagination
)

data class AnimeListItem(
    val mal_id: Int,
    val title: String,
    val images: Images,
    val episodes: Int?,
    val score: Double?,
    val synopsis: String?,
    val genres: List<Genre>?,
    val trailer: Trailer?
)

data class AnimeDetailResponse(
    val data: AnimeDetail
)

data class AnimeDetail(
    val mal_id: Int,
    val title: String,
    val images: Images,
    val episodes: Int?,
    val score: Double?,
    val synopsis: String?,
    val genres: List<Genre>?,
    val trailer: Trailer?,
    val characters: List<Character>?
)

data class Images(
    val jpg: ImageUrls,
    val webp: ImageUrls
)

data class ImageUrls(
    val image_url: String,
    val small_image_url: String,
    val large_image_url: String
)

data class Genre(
    val mal_id: Int,
    val name: String
)

data class Trailer(
    val youtube_id: String?,
    val url: String?,
    val embed_url: String?
)

data class Character(
    val character: CharacterInfo,
    val role: String
)

data class CharacterInfo(
    val mal_id: Int,
    val name: String,
    val image_url: String
)

data class Pagination(
    val last_visible_page: Int,
    val has_next_page: Boolean
)