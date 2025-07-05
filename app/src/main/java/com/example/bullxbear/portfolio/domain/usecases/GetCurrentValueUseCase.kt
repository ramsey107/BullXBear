package com.example.bullxbear.portfolio.domain.usecases

import com.example.bullxbear.portfolio.source.model.UserHolding
import com.example.bullxbear.core.Util
import com.example.bullxbear.portfolio.di.QCurrentValueStrategy
import com.example.bullxbear.portfolio.domain.strategy.CalculationStrategy
import com.example.bullxbear.portfolio.domain.strategy.CurrentValueStrategy
import javax.inject.Inject

class GetCurrentValueUseCase @Inject constructor(
    @QCurrentValueStrategy val strategy: CalculationStrategy
) {
    operator fun invoke(holdings: List<UserHolding>): Double {
        return strategy.calculate(holdings)
    }
}