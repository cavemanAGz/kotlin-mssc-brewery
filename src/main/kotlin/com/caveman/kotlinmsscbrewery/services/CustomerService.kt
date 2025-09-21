package com.caveman.kotlinmsscbrewery.services

import com.caveman.kotlinmsscbrewery.web.model.CustomerDTO
import java.util.UUID

interface CustomerService {
    fun getCustomerById(id: UUID): CustomerDTO
    fun addNewCustomer(customerDTO: CustomerDTO): CustomerDTO
    fun updateCustomer(customerId: UUID, customerDTO: CustomerDTO)
    fun deleteCustomer(customerId: UUID)
}