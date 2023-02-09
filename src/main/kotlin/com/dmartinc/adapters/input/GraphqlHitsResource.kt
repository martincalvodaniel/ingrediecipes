package com.dmartinc.adapters.input

import com.dmartinc.ports.output.HitsRepository
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class GraphqlHitsResource(
    private val hitsRepository: HitsRepository
) {

    @Query
    fun countHits(): Long = hitsRepository.countHits()
}
