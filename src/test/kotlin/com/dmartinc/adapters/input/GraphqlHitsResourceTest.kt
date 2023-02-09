package com.dmartinc.adapters.input

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test

@QuarkusTest
class GraphqlHitsResourceTest {

    @Test
    fun testGraphqlEndpoint() {
        given().header("Content-Type", "application/json")
            .body("{\"query\":\"query{countHits}\",\"operationName\":null}")
            .`when`()
            .post("/graphql")
            .then()
            .statusCode(200)
    }
}
