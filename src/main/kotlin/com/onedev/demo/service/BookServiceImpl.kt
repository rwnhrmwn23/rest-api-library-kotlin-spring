package com.onedev.demo.service

import com.onedev.demo.entity.Book
import com.onedev.demo.entity.User
import com.onedev.demo.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl : BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository

    override fun login(user: User): User? {
        return bookRepository.login(user.email, user.password)
    }

    override fun register(user: User): User? {
        return bookRepository.register(user.name, user.email, user.password)
    }

    override fun getBooks(): List<Book> {
        return bookRepository.getBooks()
    }

    override fun getBookById(id: String): Book? {
        return bookRepository.getBookById(id)
    }

    override fun getBooksByUserId(userId: String): List<Book> {
        return bookRepository.getBooksByUserId(userId)
    }

    override fun addBook(book: Book): List<Book> {
        return bookRepository.addBook(book.title, book.author, book.linkImage, book.userId)
    }

    override fun updateBook(id: String, book: Book): Book? {
        return bookRepository.updateBook(id, book.title, book.author, book.linkImage)
    }

    override fun deleteBook(id: String): Book? {
        return bookRepository.deleteBook(id)
    }
}