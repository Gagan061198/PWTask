package com.example.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.template.ui.screens.AnimeDetailScreen
import com.example.template.ui.screens.AnimeListScreen
import com.example.template.ui.theme.TemplateTheme
import com.example.template.ui.viewmodel.AnimeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimeApp()
                }
            }
        }
    }
}

@Composable
fun AnimeApp() {
    var selectedAnimeId by remember { mutableStateOf<Int?>(null) }
    val viewModel: AnimeViewModel = hiltViewModel()

    if (selectedAnimeId != null) {
        AnimeDetailScreen(
            viewModel = viewModel,
            animeId = selectedAnimeId!!,
            onBackClick = { selectedAnimeId = null }
        )
    } else {
        AnimeListScreen(
            viewModel = viewModel,
            onAnimeClick = { animeId -> selectedAnimeId = animeId }
        )
    }
}