package com.caveman.kotlinmsscbrewery.services

import com.caveman.kotlinmsscbrewery.web.model.BeerDto
import java.util.UUID

interface BeerService {
    fun getBeerById(beerId: UUID): BeerDto
    fun saveNewBeer(newBeer: BeerDto): BeerDto
}