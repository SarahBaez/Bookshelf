package com.example.bookshelf.network

data class QueryResponse(val items: List<BookItem>?)
data class BookItem(val id: String)
data class BookInfo(val id: String, val volumeInfo: VolumeInfo)
data class VolumeInfo(val title: String, val imageLinks: ImageLinks?)
data class ImageLinks(val thumbnail: String?)