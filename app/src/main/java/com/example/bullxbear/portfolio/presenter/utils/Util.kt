package com.example.bullxbear.portfolio.presenter.utils

import com.example.bullxbear.portfolio.domain.usecases.HoldingsUseCase
import com.example.bullxbear.portfolio.presenter.model.UiStockCalculationState
import com.example.bullxbear.portfolio.presenter.model.UiStockState
import com.example.bullxbear.portfolio.source.model.UserHolding

object Util {

    fun getUiStockStateList(holdings: List<UserHolding>): List<UiStockState> {
        val uiStockStateList = holdings.map { _holding ->
            val pnl = (_holding.quantity * _holding.ltp) - (_holding.quantity * _holding.avgPrice)
            UiStockState(
                ltp = _holding.ltp,
                qty = _holding.quantity,
                symbol = _holding.symbol,
                pnl = pnl
            )
        }
        return uiStockStateList
    }

    fun getUiStockCalculationState(holdingsUseCase: HoldingsUseCase, holdings: List<UserHolding>): UiStockCalculationState {
        val uiStockCalculationState = UiStockCalculationState(
            holdingsUseCase.getCurrentValueUseCase(holdings),
            holdingsUseCase.getTodayPnLUseCase(holdings),
            holdingsUseCase.getTotalPnLUseCase(holdings),
            holdingsUseCase.getTotalInvestmentUseCase(holdings),
        )
        return uiStockCalculationState
    }
}