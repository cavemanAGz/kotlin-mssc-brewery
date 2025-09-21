package com.caveman.kotlinmsscbrewery.services

import com.caveman.kotlinmsscbrewery.web.model.CustomerDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomerServiceImpl : CustomerService {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(CustomerServiceImpl::class.java)
    }

    override fun getCustomerById(id: UUID): CustomerDTO {
        return CustomerDTO(
            id = UUID.randomUUID(),
            customerName = "Joe Bob Beermen-Kotlin"
        )
    }

    override fun addNewCustomer(customerDTO: CustomerDTO): CustomerDTO {
        return CustomerDTO(
            id = UUID.randomUUID(),
            customerName = customerDTO.customerName
        )
    }

    override fun updateCustomer(
        customerId: UUID,
        customerDTO: CustomerDTO
    ) {
        logger.debug("Update Customer: {}", customerId)
    }

    override fun deleteCustomer(customerId: UUID) {
        logger.debug("Delete Customer: {}", customerId)
    }
}