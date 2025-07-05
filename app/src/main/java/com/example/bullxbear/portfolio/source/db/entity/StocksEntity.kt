package com.example.bullxbear.portfolio.source.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock")
data class StocksEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int = 0,

    @ColumnInfo("symbol")
    val symbol: String,

    @ColumnInfo("quantity")
    val quantity: Int,

    @ColumnInfo("ltp")
    val ltp: Double,

    @ColumnInfo("avgPrice")
    val avgPrice: Double,

    @ColumnInfo("close")
    val close: Double
)
