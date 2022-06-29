package com.onedev.demo.database

import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {
    private val databaseURL = System.getenv("DATABASE_URL")
    val database: MongoClient = KMongo.createClient(databaseURL)
}