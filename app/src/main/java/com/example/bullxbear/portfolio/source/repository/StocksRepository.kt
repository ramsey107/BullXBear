package com.example.bullxbear.portfolio.source.repository

import com.example.bullxbear.portfolio.domain.model.Stocks
import com.example.bullxbear.portfolio.domain.repository.IStockRepository
import com.example.bullxbear.portfolio.source.db.dao.StockDao
import com.example.bullxbear.portfolio.source.db.entity.StocksEntity
import com.example.bullxbear.portfolio.source.model.UserHolding
import com.example.bullxbear.portfolio.source.remote.StockService
import okio.IOException
import javax.inject.Inject

class StocksRepository @Inject constructor(
    private val stockService: StockService,
    private val stockDao: StockDao
) : IStockRepository {
    override suspend fun getStock(): Stocks {
        try {
            val stocks = stockService.getStocks().data.userHolding
            val dbStocks = stockService.getStocks().data.userHolding.map { _stock ->
                StocksEntity(
                    symbol = _stock.symbol,
                    quantity = _stock.quantity,
                    ltp = _stock.ltp,
                    avgPrice = _stock.avgPrice,
                    close = _stock.close,
                )
            }
            stockDao.saveStocksToDB(dbStocks)
            return Stocks(stocks)
        } catch (e: IOException) {
            val dbStocks = stockDao.getStocksFromDB()
            val userHoldings = dbStocks.map { _stock ->
                UserHolding(
                    symbol = _stock.symbol,
                    quantity = _stock.quantity,
                    ltp = _stock.ltp,
                    avgPrice = _stock.avgPrice,
                    close = _stock.close
                )
            }
            return Stocks(userHoldings)
        }
    }
}
