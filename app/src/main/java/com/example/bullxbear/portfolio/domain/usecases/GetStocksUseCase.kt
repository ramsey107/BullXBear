package com.example.bullxbear.portfolio.domain.usecases

import com.example.bullxbear.portfolio.domain.model.Stocks
import com.example.bullxbear.portfolio.domain.repository.IStockRepository
import javax.inject.Inject

class GetStocksUseCase @Inject constructor(
    private val iStockRepository: IStockRepository
) {
    suspend operator fun invoke(): Stocks {
        return iStockRepository.getStock()
    }
}