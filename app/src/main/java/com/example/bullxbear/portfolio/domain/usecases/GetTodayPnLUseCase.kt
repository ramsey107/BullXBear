package com.example.bullxbear.portfolio.domain.usecases

import com.example.bullxbear.portfolio.source.model.UserHolding
import com.example.bullxbear.core.Util
import com.example.bullxbear.portfolio.di.QTodayPnLStrategy
import com.example.bullxbear.portfolio.domain.strategy.CalculationStrategy
import com.example.bullxbear.portfolio.domain.strategy.TodayPnLStrategy
import javax.inject.Inject

class GetTodayPnLUseCase @Inject constructor(
    @QTodayPnLStrategy val strategy: CalculationStrategy
){
    operator fun invoke(holdings: List<UserHolding>): Double {
        return strategy.calculate(holdings)
    }
}