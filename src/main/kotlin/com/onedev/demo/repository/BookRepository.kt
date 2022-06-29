package com.onedev.demo.repository

import com.onedev.demo.entity.Book
import com.onedev.demo.entity.User

interface BookRepository {
    fun login(email: String, password: String): User?
    fun register(name: String, email: String, password: String): User?
    fun getBooks(): List<Book>
    fun getBookById(id: String): Book?
    fun getBooksByUserId(userId: String): List<Book>
    fun addBook(title: String, author: String, linkImage: String, userId: String): List<Book>
    fun updateBook(id: String, title: String, author: String, linkImage: String): Book?
    fun deleteBook(id: String): Book?
}