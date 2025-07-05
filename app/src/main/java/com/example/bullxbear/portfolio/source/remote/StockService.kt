package com.example.bullxbear.portfolio.source.remote

import com.example.bullxbear.portfolio.source.model.StockDTO
import retrofit2.http.GET

interface StockService {

    @GET("/user")
    suspend fun getStocks(): StockDTO
}