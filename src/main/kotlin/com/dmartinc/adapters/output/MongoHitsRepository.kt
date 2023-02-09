package com.dmartinc.adapters.output

import com.dmartinc.ports.output.HitsRepository
import com.mongodb.client.MongoClient
import org.bson.Document
import java.time.LocalDate
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MongoHitsRepository(private val mongoClient: MongoClient) : HitsRepository {

    override fun insertHit() {
        mongoClient.getDatabase("ingrediecipes")
            .getCollection("hits")
            .insertOne(Document("timestamp", LocalDate.now()))
    }

    override fun countHits(): Long {
        val hitsCount = mongoClient.getDatabase("ingrediecipes")
            .getCollection("hits")
            .countDocuments()
        println(hitsCount)
        return hitsCount
    }
}
