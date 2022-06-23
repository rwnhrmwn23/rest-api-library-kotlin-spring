package com.onedev.demo.repository

import com.mongodb.client.MongoCollection
import com.onedev.demo.database.DatabaseComponent
import com.onedev.demo.entity.User
import org.litote.kmongo.eq
import org.litote.kmongo.find
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class AuthRepositoryImpl: AuthRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun authCollection(): MongoCollection<User> =
        databaseComponent.database.getDatabase("lib_auth").getCollection()

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
}