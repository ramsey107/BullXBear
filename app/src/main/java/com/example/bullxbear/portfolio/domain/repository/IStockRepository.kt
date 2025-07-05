package com.example.bullxbear.portfolio.domain.repository

import com.example.bullxbear.portfolio.domain.model.Stocks

interface IStockRepository {
    suspend fun getStock(): Stocks
}