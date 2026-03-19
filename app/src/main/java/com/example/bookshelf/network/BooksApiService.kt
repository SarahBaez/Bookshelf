package com.example.bookshelf.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): QueryResponse

    @GET("volumes/{volumeId}")
    suspend fun getBookInfo(@Path("volumeId") volumeId: String): BookInfo
}