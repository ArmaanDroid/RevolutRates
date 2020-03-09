package com.armaan.revolutrates.webapi

import com.armaan.revolutrates.models.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface RatesApi {
    @GET("")
    fun getRates(@Query("base") currency: String) : Deferred<Response<ApiResponse>>
}