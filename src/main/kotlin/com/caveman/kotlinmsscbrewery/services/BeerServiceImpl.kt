package com.caveman.kotlinmsscbrewery.services

import com.caveman.kotlinmsscbrewery.web.model.BeerDto
import org.slf4j.Logger

import org.slf4j.LoggerFactory

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BeerServiceImpl : BeerService {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(BeerServiceImpl::class.java)
    }

    override fun getBeerById(beerId: UUID): BeerDto {
        return BeerDto(
            id = UUID.randomUUID(),
            beerName = "Galaxy Cat",
            beerStyle = "Pale Ale",
            upc = 12345L
        )
    }

    override fun saveNewBeer(newBeer: BeerDto): BeerDto {
        return BeerDto(
            id = UUID.randomUUID(),
            beerName = newBeer.beerName,
            beerStyle = newBeer.beerStyle,
            upc = newBeer.upc,
        )
    }

    override fun updateBeer(beerId: UUID, updatedBeer: BeerDto) {
        logger.info("Updating beer with id: $beerId")
    }
}