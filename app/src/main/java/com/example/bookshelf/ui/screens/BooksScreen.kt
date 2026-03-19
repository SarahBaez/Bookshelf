package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.network.BookInfo

@Composable
fun BooksScreen(booksUiState: BooksUiState, modifier: Modifier = Modifier) {
    when (booksUiState) {
        is BooksUiState.Loading -> Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
        is BooksUiState.Success -> BooksGridScreen(booksUiState.books, modifier)
        is BooksUiState.Error -> Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Error al cargar") }
    }
}

@Composable
fun BooksGridScreen(books: List<BookInfo>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(items = books, key = { book -> book.id }) { book ->
            Card(
                modifier = Modifier.padding(4.dp).fillMaxWidth().aspectRatio(0.6f),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                val imageUrl = book.volumeInfo.imageLinks?.thumbnail?.replace("http:", "https:")
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = book.volumeInfo.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}