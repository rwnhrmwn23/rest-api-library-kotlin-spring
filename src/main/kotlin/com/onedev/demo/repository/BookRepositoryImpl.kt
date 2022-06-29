package com.onedev.demo.repository

import com.mongodb.client.MongoCollection
import com.onedev.demo.database.DatabaseComponent
import com.onedev.demo.entity.Book
import com.onedev.demo.entity.User
import org.litote.kmongo.eq
import org.litote.kmongo.find
import org.litote.kmongo.getCollection
import org.litote.kmongo.setValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl: BookRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private val dbURL = System.getenv("DB_NAME")
    private fun bookCollection(): MongoCollection<Book> =
        databaseComponent.database.getDatabase(dbURL).getCollection()

    private fun authCollection(): MongoCollection<User> =
        databaseComponent.database.getDatabase(dbURL).getCollection()

    override fun login(email: String, password: String): User? {
        return authCollection().find(User::email eq email, User::password eq password).first()
    }

    override fun register(name: String, email: String, password: String): User? {
        val user = User(
            name = name,
            email = email,
            password = password,
        )
        val insert = authCollection().insertOne(user)
        return if (insert.wasAcknowledged()) {
            login(email, password)
        } else {
            throw IllegalStateException("Register Failed!")
        }
    }

    override fun getBooks(): List<Book> {
        return bookCollection().find().toList()
    }

    override fun getBookById(id: String): Book? {
        return bookCollection().find(Book::id eq id).first()
    }

    override fun getBooksByUserId(userId: String): List<Book> {
        return bookCollection().find(Book::userId eq userId).toList()
    }

    override fun addBook(title: String, author: String, linkImage: String, userId: String): List<Book> {
        val book = Book(
            title = title,
            author = author,
            linkImage = linkImage,
            userId = userId
        )
        val insert = bookCollection().insertOne(book)
        return if (insert.wasAcknowledged()) {
            getBooksByUserId(userId)
        } else {
            throw IllegalStateException("Add Book Data Failed!")
        }
    }

    override fun updateBook(id: String, title: String, author: String, linkImage: String): Book? {
        val listBson = listOf(
            setValue(Book::title, title),
            setValue(Book::author, author),
            setValue(Book::linkImage, linkImage)
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