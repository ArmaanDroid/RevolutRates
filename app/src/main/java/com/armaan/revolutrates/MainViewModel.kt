package com.armaan.revolutrates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.armaan.revolutrates.models.ApiResponse
import com.armaan.revolutrates.models.Rates
import com.armaan.revolutrates.repository.RatesRepository
import com.armaan.revolutrates.webapi.WebClient
import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.CoroutineContext

class MainViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO

    private val scope = CoroutineScope(coroutineContext)

    private val repository: RatesRepository = RatesRepository(WebClient().ratesApi)

    val ratesLiveData = MutableLiveData<Rates>()

    fun fetchRates(currencyCode: String) {
        scope.launch {
            val response = repository.getRates(currencyCode)
            ratesLiveData.postValue(response?.rates)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}