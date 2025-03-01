package com.example.franco_rojas_20250303

import android.os.AsyncTask
import android.util.Log
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class BitcoinTask(private val callback: (String) -> Unit) : AsyncTask<Void, Void, String>() {
    override fun doInBackground(vararg params: Void?): String {
        val url = URL("https://mindicador.cl/api/bitcoin")
        val connection = url.openConnection() as HttpURLConnection
        return connection.inputStream.bufferedReader().readText()
    }

    override fun onPostExecute(result: String?) {
        result?.let {
            val json = JSONObject(it)
            val precio = json.getJSONArray("serie").getJSONObject(0).getDouble("valor")
            callback(precio.toString())
        }
    }
}
