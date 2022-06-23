package com.onedev.demo.repository

import com.mongodb.client.MongoCollection
import com.onedev.demo.database.DatabaseComponent
import com.onedev.demo.entity.Book
import com.onedev.demo.entity.User
import org.bson.conversions.Bson
import org.litote.kmongo.eq
import org.litote.kmongo.find
import org.litote.kmongo.getCollection
import org.litote.kmongo.setValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.Arrays

@Repository
class BookRepositoryImpl: BookRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun bookCollection(): MongoCollection<Book> =
        databaseComponent.database.getDatabase("lib_book").getCollection()

    override fun getBooks(): List<Book> {
        return bookCollection().find().toList()
    }

    override fun getBookById(id: String): Book? {
        return bookCollection().find(Book::id eq id).first()
    }

    override fun getBooksByUserId(userId: String): List<Book> {
        return bookCollection().find(Book::userId eq userId).toList()
    }

    override fun addBook(title: String, author: String, userId: String): List<Book> {
        val book = Book(
            title = title,
            author = author,
            userId = userId
        )
        val insert = bookCollection().insertOne(book)
        return if (insert.wasAcknowledged()) {
            getBooksByUserId(userId)
        } else {
            throw IllegalStateException("Add Book Data Failed!")
        }
    }

    override fun updateBook(id: String, title: String, author: String): Book? {
        val listBson = listOf(
            setValue(Book::title, title),
            setValue(Book::author, author)
        )
        val update = bookCollection().updateOne(Book::id eq id, listBson)
        return if (update.wasAcknowledged()) {
            getBookById(id)
        } else {
            throw IllegalStateException("Update Book Data Failed!")
        }
    }

    override fun deleteBook(id: String): Book? {
        val delete = bookCollection().deleteOne(Book::id eq id)
        return if (delete.wasAcknowledged()) {
            getBookById(id)
        } else {
            throw IllegalStateException("Delete Book Data Failed!")
        }
    }
}