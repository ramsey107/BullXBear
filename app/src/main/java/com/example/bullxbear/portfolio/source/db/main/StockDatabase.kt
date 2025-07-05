package com.example.bullxbear.portfolio.source.db.main

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bullxbear.portfolio.source.db.dao.StockDao
import com.example.bullxbear.portfolio.source.db.entity.StocksEntity

@Database(entities = [StocksEntity::class], version = 1, exportSchema = false)
abstract class StockDatabase: RoomDatabase() {
    abstract fun stockDao(): StockDao
}