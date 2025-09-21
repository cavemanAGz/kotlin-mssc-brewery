package com.caveman.kotlinmsscbrewery.web.controller

import com.caveman.kotlinmsscbrewery.services.CustomerService
import com.caveman.kotlinmsscbrewery.web.model.CustomerDTO
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

@RequestMapping("/api/v1/customer")
@RestController
class CustomerController(
    private val customerService: CustomerService
) {

    @GetMapping("/{customerId}")
fun getCustomerById(@PathVariable customerId: UUID): ResponseEntity<CustomerDTO> {
        return ResponseEntity.ok(customerService.getCustomerById(id = customerId))
    }

    @PostMapping()
    fun handlePost(@RequestBody customerDTO: CustomerDTO): ResponseEntity<Void> {
        val newCustomer = customerService.addNewCustomer(customerDTO)
        val headers: HttpHeaders = HttpHeaders()
        headers.add("Location", "/api/v1/customer/${newCustomer.id}")
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{customerId}")
    fun handleUpdate(@PathVariable customerId: UUID, @RequestBody customerDTO: CustomerDTO): ResponseEntity<Void> {
        customerService.updateCustomer(customerId, customerDTO)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun handleDelete(@PathVariable customerId: UUID) {
        customerService.deleteCustomer(customerId)
    }
}