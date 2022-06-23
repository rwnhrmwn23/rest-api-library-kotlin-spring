package com.onedev.demo.service

import com.onedev.demo.entity.Book

interface BookService {
    fun getBooks(): List<Book>
    fun getBookById(id: String): Book?
    fun getBooksByUserId(userId: String): List<Book>
    fun addBook(book: Book): List<Book>
    fun updateBook(id: String, book: Book): Book?
    fun deleteBook(id: String): Book?
}