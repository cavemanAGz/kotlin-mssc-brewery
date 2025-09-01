package com.caveman.kotlinmsscbrewery.web.controller

import com.caveman.kotlinmsscbrewery.services.CustomerService
import com.caveman.kotlinmsscbrewery.web.model.CustomerDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
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

}