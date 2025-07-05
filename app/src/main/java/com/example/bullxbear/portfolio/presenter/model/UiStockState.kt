package com.example.bullxbear.portfolio.presenter.model

data class UiStockState(
    val ltp: Double = 0.0,
    val qty: Int = 0,
    val symbol: String = "",
    val pnl: Double = 0.0
)
