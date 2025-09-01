package com.caveman.kotlinmsscbrewery.web.model

import java.util.UUID

data class CustomerDTO(
    val id: UUID,
    val customerName: String,
)
