package com.example.bullxbear.portfolio.domain.strategy

import com.example.bullxbear.portfolio.source.model.UserHolding

interface CalculationStrategy {
    fun calculate(holdings: List<UserHolding>): Double
}