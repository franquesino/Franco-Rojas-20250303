package com.example.franco_rojas_20250303.network

import com.example.franco_rojas_20250303.model.BitcoinResponse
import retrofit2.Call
import retrofit2.http.GET

interface BitcoinApiService {
    @GET("bitcoin")
    fun getBitcoinValues(): Call<BitcoinResponse>
}
