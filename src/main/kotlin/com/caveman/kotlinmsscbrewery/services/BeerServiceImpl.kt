package com.caveman.kotlinmsscbrewery.services

import com.caveman.kotlinmsscbrewery.web.model.BeerDto
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BeerServiceImpl : BeerService {

    override fun getBeerById(beerId: UUID): BeerDto {
        return BeerDto(
            id = UUID.randomUUID(),
            beerName = "Galaxy Cat",
            beerStyle = "Pale Ale",
            upc = 12345L
        )
    }
}