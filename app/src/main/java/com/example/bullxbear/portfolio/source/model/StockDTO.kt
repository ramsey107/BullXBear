package com.example.bullxbear.portfolio.source.model

data class StockDTO(
    val data: StockData
)

data class UserHolding(
    val symbol: String,
    val quantity: Int,
    val ltp: Double,
    val avgPrice: Double,
    val close: Double
)

data class StockData(
    val userHolding: List<UserHolding>
)