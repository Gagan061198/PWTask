package com.example.template.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.data.model.AnimeDetail
import com.example.template.data.model.AnimeListItem
import com.example.template.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {
    private val _animeList = MutableStateFlow<List<AnimeListItem>>(emptyList())
    val animeList: StateFlow<List<AnimeListItem>> = _animeList.asStateFlow()

    private val _selectedAnime = MutableStateFlow<AnimeDetail?>(null)
    val selectedAnime: StateFlow<AnimeDetail?> = _selectedAnime.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadTopAnime()
    }

    fun loadTopAnime() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                _animeList.value = repository.getTopAnime()
            } catch (e: Exception) {
                _error.value = "Failed to load anime list: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadAnimeDetails(animeId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                _selectedAnime.value = repository.getAnimeDetails(animeId)
            } catch (e: Exception) {
                _error.value = "Failed to load anime details: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
} 