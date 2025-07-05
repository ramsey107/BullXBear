package com.example.bullxbear.portfolio.di

import android.content.Context
import androidx.room.Room
import com.example.bullxbear.portfolio.source.db.dao.StockDao
import com.example.bullxbear.portfolio.source.db.main.StockDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): StockDatabase {
        return Room.databaseBuilder(
            context,
            StockDatabase::class.java,
            "stock_db"
        ).build()
    }

    @Provides
    fun provideStockDao(db: StockDatabase): StockDao {
        return db.stockDao()
    }
}