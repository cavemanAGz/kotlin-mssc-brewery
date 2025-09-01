package com.caveman.kotlinmsscbrewery.services

import com.caveman.kotlinmsscbrewery.web.model.CustomerDTO
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomerServiceImpl : CustomerService {
    override fun getCustomerById(id: UUID): CustomerDTO {
        return CustomerDTO(
            id = UUID.randomUUID(),
            customerName = "Joe Bob Beermen-Kotlin"
        )
    }
}