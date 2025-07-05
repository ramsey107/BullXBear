package com.example.bullxbear.portfolio.di

import com.example.bullxbear.portfolio.domain.repository.IStockRepository
import com.example.bullxbear.portfolio.source.repository.StocksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun providesStockRepository(
        stocksRepository: StocksRepository
    ): IStockRepository

}