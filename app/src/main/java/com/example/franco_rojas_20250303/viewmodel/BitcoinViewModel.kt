package com.example.franco_rojas_20250303.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.franco_rojas_20250303.model.BitcoinResponse
import com.example.franco_rojas_20250303.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BitcoinViewModel : ViewModel() {

    private val _bitcoinData = MutableLiveData<BitcoinResponse>()
    val bitcoinData: LiveData<BitcoinResponse> get() = _bitcoinData

    fun fetchBitcoinValues() {
        RetrofitClient.instance.getBitcoinValues().enqueue(object : Callback<BitcoinResponse> {
            override fun onResponse(call: Call<BitcoinResponse>, response: Response<BitcoinResponse>) {
                if (response.isSuccessful) {
                    _bitcoinData.value = response.body()
                }
            }

            override fun onFailure(call: Call<BitcoinResponse>, t: Throwable) {

            }
        })
    }
}
