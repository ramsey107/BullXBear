package com.example.bullxbear.portfolio.domain.strategy

import com.example.bullxbear.core.Util
import com.example.bullxbear.portfolio.source.model.UserHolding

class TotalInvestmentStrategy: CalculationStrategy {
    override fun calculate(holdings: List<UserHolding>): Double {
        return Util.getTotalInvestment(holdings)
    }
}