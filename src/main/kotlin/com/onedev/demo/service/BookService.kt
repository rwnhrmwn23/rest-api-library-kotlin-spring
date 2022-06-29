package com.onedev.demo.service

import com.onedev.demo.entity.Book
import com.onedev.demo.entity.User

interface BookService {
    fun login(user: User): User?
    fun register(user: User): User?
    fun getBooks(): List<Book>
    fun getBookById(id: String): Book?
    fun getBooksByUserId(userId: String): List<Book>
    fun addBook(book: Book): List<Book>
    fun updateBook(id: String, book: Book): Book?
    fun deleteBook(id: String): Book?
}