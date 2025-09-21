package com.caveman.kotlinmsscbrewery.web.controller

import com.caveman.kotlinmsscbrewery.services.BeerService
import com.caveman.kotlinmsscbrewery.web.model.BeerDto
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
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

    @PostMapping
    fun handlePost(@RequestBody newBeer: BeerDto): ResponseEntity<Void> {
        val beer = beerService.saveNewBeer(newBeer)

        val header = HttpHeaders()
        header.add("Location", "/api/v1/beer/${beer.id}")
        return ResponseEntity(header, HttpStatus.CREATED)
    }

    @PutMapping("/{beerId}")
    fun handleUpdate(@PathVariable beerId: UUID, @RequestBody updatedBeer: BeerDto): ResponseEntity<Void> {
        beerService.updateBeer(beerId, updatedBeer)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  // Same as return ResponseEntity.noContent().build()
    fun handleDelete(@PathVariable beerId: UUID) {
        beerService.deleteBeer(beerId)
    }

}