package com.example.bullxbear.portfolio.domain.strategy

import com.example.bullxbear.core.Util
import com.example.bullxbear.portfolio.source.model.UserHolding

class TotalPnLStrategy: CalculationStrategy {
    override fun calculate(holdings: List<UserHolding>): Double {
        return Util.getTotalPNL(holdings)
    }
}