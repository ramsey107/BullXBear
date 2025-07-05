package com.example.bullxbear.portfolio.di

import com.example.bullxbear.portfolio.domain.strategy.CalculationStrategy
import com.example.bullxbear.portfolio.domain.usecases.GetCurrentValueUseCase
import com.example.bullxbear.portfolio.domain.usecases.GetStocksUseCase
import com.example.bullxbear.portfolio.domain.usecases.GetTodayPnLUseCase
import com.example.bullxbear.portfolio.domain.usecases.GetTotalInvestmentUseCase
import com.example.bullxbear.portfolio.domain.usecases.GetTotalPnLUseCase
import com.example.bullxbear.portfolio.domain.usecases.HoldingsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providesHoldingsUseCase(
        getStocksUseCase: GetStocksUseCase,
        @QCurrentValueStrategy currentValueStrategy: CalculationStrategy,
        @QTodayPnLStrategy todayPnLStrategy: CalculationStrategy,
        @QTotalPnLStrategy totalPnLStrategy: CalculationStrategy,
        @QTotalInvestmentStrategy totalInvestmentStrategy: CalculationStrategy,
    ): HoldingsUseCase {
        return HoldingsUseCase(
            GetCurrentValueUseCase(currentValueStrategy),
            getStocksUseCase,
            GetTodayPnLUseCase(todayPnLStrategy),
            GetTotalInvestmentUseCase(totalInvestmentStrategy),
            GetTotalPnLUseCase(totalPnLStrategy)
        )
    }
}