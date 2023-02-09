package com.dmartinc.adapters.input

import com.dmartinc.ports.output.HitsRepository
import io.smallrye.mutiny.Uni
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hits")
class RestHitsResource(private val hitsRepository: HitsRepository) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): Uni<String> {
        hitsRepository.insertHit()
        hitsRepository.countHits()
        return Uni.createFrom().item("Hello from RESTEasy Reactive")
    }
}