package com.example.bullxbear.portfolio.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bullxbear.core.Constants.REFRESH_INTERVAL_MS
import com.example.bullxbear.portfolio.domain.usecases.HoldingsUseCase
import com.example.bullxbear.portfolio.presenter.model.UiStockCalculationState
import com.example.bullxbear.portfolio.presenter.model.UiStockState
import com.example.bullxbear.portfolio.presenter.utils.Util.getUiStockCalculationState
import com.example.bullxbear.portfolio.presenter.utils.Util.getUiStockStateList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StocksViewModel @Inject constructor(
    private val holdingsUseCase: HoldingsUseCase
) : ViewModel() {

    private var _uiStockState = MutableLiveData<List<UiStockState>>()
    val uiStockState: LiveData<List<UiStockState>> = _uiStockState

    private var _uiStockCalculationState = MutableLiveData<UiStockCalculationState>()
    val uiStockCalculationState: LiveData<UiStockCalculationState> = _uiStockCalculationState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG", "holdingsUseCase")
            while (isActive) {
                val holdings = holdingsUseCase.getStocksUseCase().data
                val uiStockCalculationState = getUiStockCalculationState(holdingsUseCase, holdings)
                val uiStockState = getUiStockStateList(holdings)

                Log.d("TAG",uiStockState.toString())
                Log.d("TAG",uiStockCalculationState.toString())

                _uiStockState.postValue(uiStockState)
                _uiStockCalculationState.postValue(uiStockCalculationState)

                delay(REFRESH_INTERVAL_MS)
            }
        }
    }

}