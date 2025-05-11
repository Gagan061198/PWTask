# PWTask - Anime app

This is an Android app that allows users to explore anime series using the Jikan API. The app helps user sort through a list of anime and read about it, and possibly watch a trailer ( if available).

## Features

### Anime List Page
- Displays a list of top-rated anime
- Shows key information for each anime like Title, Number of Episodes, Rating/score, Poster etc.

### Anime Detail Page
- Comprehensive information about selected anime like Youtube Video Player for trailer (if available), Title, Plot/Synopsis, Genre etc.

## Technical Aspects

### Architecture
- MVVM (Model-View-ViewModel) architecture
- Jetpack Compose for UI
- Kotlin Coroutines for asynchronous operations
- Retrofit for API calls
- Coil for image loading
- Youtube Player for Android ( https://github.com/PierfrancescoSoffritti/android-youtube-player) for video playback

### Dependencies
- AndroidX Core KTX
- Jetpack Compose
- Dagger-Hilt for DI
- Retrofit2
- Coil

  
## Getting Started

1. Clone the repository
2. Open the project in Android Studio
3. Build and run the application


1. Implement search functionality
2. Add offline support with local caching
3. Implement user authentication
4. Add favorites/bookmarks feature
5. Implement pagination for the anime list
6. Add more detailed character information
7. Implement filtering and sorting options
