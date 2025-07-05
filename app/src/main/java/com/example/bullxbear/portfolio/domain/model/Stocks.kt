package com.example.bullxbear.portfolio.domain.model

import com.example.bullxbear.portfolio.source.model.UserHolding

data class Stocks(
    val data: List<UserHolding>
)