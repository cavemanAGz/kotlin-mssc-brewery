package com.caveman.kotlinmsscbrewery.web.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.UUID

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BeerDto(
    val id: UUID = UUID.randomUUID(),
    val beerName: String,
    val beerStyle: String,
    val upc: Long = 0L,
)
