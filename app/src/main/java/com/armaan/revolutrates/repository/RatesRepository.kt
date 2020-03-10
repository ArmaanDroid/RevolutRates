package com.armaan.revolutrates.repository

import com.armaan.revolutrates.models.ApiResponse
import com.armaan.revolutrates.webapi.RatesApi
import java.util.*

class RatesRepository(private val api: RatesApi) : BaseRepository() {

    suspend fun getRates( baseCurrency: String): ApiResponse? {
       val response = safeApiCall(
           call = {api.getRates(baseCurrency).await()},
           errorMessage = "Error Fetching Popular Movies"
       )
        return response
    }
}