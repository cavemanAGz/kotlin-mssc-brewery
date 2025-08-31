package com.caveman.kotlinmsscbrewery.web.model

import java.util.UUID

data class BeerDto(
    val id: UUID,
    val beerName: String,
    val beerStyle: String,
    val upc: Long,
)
