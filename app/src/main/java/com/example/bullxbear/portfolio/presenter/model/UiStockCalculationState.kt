package com.example.bullxbear.portfolio.presenter.model

data class UiStockCalculationState(
    val currentValue: Double = 0.0,
    val totalInvestment: Double = 0.0,
    val totalPnL: Double = 0.0,
    val todayPnL: Double = 0.0,
    val netQuantity: Int = 0
)
