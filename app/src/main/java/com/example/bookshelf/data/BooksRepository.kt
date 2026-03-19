package com.example.bookshelf.data

import com.example.bookshelf.network.BookInfo
import com.example.bookshelf.network.BooksApiService
import com.example.bookshelf.network.ImageLinks
import com.example.bookshelf.network.VolumeInfo
import kotlinx.coroutines.delay

interface BooksRepository {
    suspend fun getBooks(query: String): List<BookInfo>
}

class NetworkBooksRepository(
    // Dejamos el apiService aquí para que tu AppContainer no marque error,
    // pero lo vamos a ignorar por completo.
    private val booksApiService: BooksApiService
) : BooksRepository {

    override suspend fun getBooks(query: String): List<BookInfo> {
        // Simulamos 1.5 segundos de "descarga" para que alcance a salir
        // el circulito de carga en tu pantalla
        delay(1500)

        // Retornamos nuestros datos de prueba con imágenes genéricas que sabemos que funcionan
        return listOf(
            BookInfo(
                id = "1",
                volumeInfo = VolumeInfo(
                    title = "El arte de programar",
                    imageLinks = ImageLinks("https://picsum.photos/id/24/200/300")
                )
            ),
            BookInfo(
                id = "2",
                volumeInfo = VolumeInfo(
                    title = "Clean Architecture",
                    imageLinks = ImageLinks("https://picsum.photos/id/367/200/300")
                )
            ),
            BookInfo(
                id = "3",
                volumeInfo = VolumeInfo(
                    title = "Diseño de Interfaces",
                    imageLinks = ImageLinks("https://picsum.photos/id/250/200/300")
                )
            ),
            BookInfo(
                id = "4",
                volumeInfo = VolumeInfo(
                    title = "Bases de Datos",
                    imageLinks = ImageLinks("https://picsum.photos/id/20/200/300")
                )
            ),
            BookInfo(
                id = "5",
                volumeInfo = VolumeInfo(
                    title = "Seguridad Informática",
                    imageLinks = ImageLinks("https://picsum.photos/id/3/200/300")
                )
            )
        )
    }
}