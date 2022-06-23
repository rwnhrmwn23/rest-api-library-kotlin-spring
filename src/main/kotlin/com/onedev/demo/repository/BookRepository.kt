package com.onedev.demo.repository

import com.onedev.demo.entity.Book

interface BookRepository {
    fun getBooks(): List<Book>
    fun getBookById(id: String): Book?
    fun getBooksByUserId(userId: String): List<Book>
    fun addBook(title: String, author: String, userId: String): List<Book>
    fun updateBook(id: String, title: String, author: String): Book?
    fun deleteBook(id: String): Book?
}