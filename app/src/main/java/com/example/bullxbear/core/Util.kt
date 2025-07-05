package com.example.bullxbear.core

import com.example.bullxbear.portfolio.source.model.UserHolding

class Util {

    companion object {

        fun getCurrentValue(holdings: List<UserHolding>): Double {
            var currentValue = 0.0
            holdings.forEach { _holding ->
                currentValue += _holding.quantity * _holding.ltp
            }
            return currentValue
        }

        fun getTotalInvestment(holdings: List<UserHolding>): Double {
            var totalInvestment = 0.0
            holdings.forEach { _holding ->
                totalInvestment += _holding.quantity * _holding.avgPrice
            }
            return totalInvestment
        }

        fun getTotalPNL(holdings: List<UserHolding>): Double {
            return getCurrentValue(holdings) - getTotalInvestment(holdings)
        }

        fun getTodayPNL(holdings: List<UserHolding>): Double {
            var todayPNL = 0.0
            holdings.forEach { _holding ->
                todayPNL += (_holding.close - _holding.ltp) * _holding.quantity
            }
            return todayPNL
        }
    }
}