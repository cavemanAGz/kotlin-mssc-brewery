package com.caveman.kotlinmsscbrewery.web.controller

import com.caveman.kotlinmsscbrewery.services.BeerService
import com.caveman.kotlinmsscbrewery.web.model.BeerDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/api/v1/beer")
@RestController
class BeerController(
    private val beerService: BeerService
) {

    @GetMapping("/{beerId}")
    fun getBeer(@PathVariable beerId: UUID): ResponseEntity<BeerDto> {
        return ResponseEntity.ok(beerService.getBeerById(beerId))
    }

}