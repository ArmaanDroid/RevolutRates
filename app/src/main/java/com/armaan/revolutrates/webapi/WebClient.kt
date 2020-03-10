package com.armaan.revolutrates.webapi

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class WebClient {
    val BASE_URL="https://hiring.revolut.codes/api/android/"

    //OkhttpClient for building http request url, Interceptor to look at the response
    private val httpClient = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    // Retrofit client to make the request & Moshi Converter to consume the response
    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    // RatesApi instance to invoke the request
    val ratesApi : RatesApi = retrofit().create(RatesApi::class.java)

}