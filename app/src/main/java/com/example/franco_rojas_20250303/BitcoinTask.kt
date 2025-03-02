package com.example.franco_rojas_20250303

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class BitcoinTask(private val callback: (String) -> Unit) {

    fun fetchBitcoinPrice() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val url = URL("https://mindicador.cl/api/bitcoin")
                val connection = url.openConnection() as HttpURLConnection
                val response = connection.inputStream.bufferedReader().readText()

                withContext(Dispatchers.Main) {
                    val json = JSONObject(response)
                    val precio = json.getJSONArray("serie").getJSONObject(0).getDouble("valor")
                    callback(precio.toString())
                }
            } catch (e: Exception) {
                Log.e("BitcoinTask", "Error al obtener datos: ${e.message}")
            }
        }
    }
}
