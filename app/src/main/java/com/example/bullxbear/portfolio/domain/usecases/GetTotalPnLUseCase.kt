package com.example.bullxbear.portfolio.domain.usecases

import com.example.bullxbear.portfolio.di.QTotalPnLStrategy
import com.example.bullxbear.portfolio.domain.strategy.CalculationStrategy
import com.example.bullxbear.portfolio.source.model.UserHolding
import javax.inject.Inject

class GetTotalPnLUseCase @Inject constructor(
    @QTotalPnLStrategy val strategy: CalculationStrategy
) {
    operator fun invoke(holdings: List<UserHolding>): Double {
        return strategy.calculate(holdings)
    }
}