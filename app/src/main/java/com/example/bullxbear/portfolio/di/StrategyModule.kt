package com.example.bullxbear.portfolio.di

import com.example.bullxbear.portfolio.domain.strategy.CalculationStrategy
import com.example.bullxbear.portfolio.domain.strategy.CurrentValueStrategy
import com.example.bullxbear.portfolio.domain.strategy.TodayPnLStrategy
import com.example.bullxbear.portfolio.domain.strategy.TotalInvestmentStrategy
import com.example.bullxbear.portfolio.domain.strategy.TotalPnLStrategy
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StrategyModule {

    @Provides
    @Singleton
    @QCurrentValueStrategy
    fun provideCurrentValueStrategy(): CalculationStrategy = CurrentValueStrategy()

    @Provides
    @Singleton
    @QTodayPnLStrategy
    fun provideTodayPnLStrategy(): CalculationStrategy = TodayPnLStrategy()

    @Provides
    @Singleton
    @QTotalPnLStrategy
    fun provideTotalPnLStrategy(): CalculationStrategy = TotalPnLStrategy()

    @Provides
    @Singleton
    @QTotalInvestmentStrategy
    fun provideTotalInvestmentStrategy(): CalculationStrategy = TotalInvestmentStrategy()
}