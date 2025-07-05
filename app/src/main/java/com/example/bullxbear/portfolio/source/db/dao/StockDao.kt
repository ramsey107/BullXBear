package com.example.bullxbear.portfolio.source.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bullxbear.portfolio.source.db.entity.StocksEntity

@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveStocksToDB(stocks: List<StocksEntity>)

    @Query("SELECT * FROM stock")
    suspend fun getStocksFromDB(): List<StocksEntity>

}