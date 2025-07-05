package com.example.bullxbear.portfolio.domain.usecases

import javax.inject.Inject

data class HoldingsUseCase @Inject constructor(
    val getCurrentValueUseCase: GetCurrentValueUseCase,
    val getStocksUseCase: GetStocksUseCase,
    val getTodayPnLUseCase: GetTodayPnLUseCase,
    val getTotalInvestmentUseCase: GetTotalInvestmentUseCase,
    val getTotalPnLUseCase: GetTotalPnLUseCase
)
