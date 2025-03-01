package com.example.franco_rojas_20250303

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.franco_rojas_20250303.adapter.BitcoinAdapter
import com.example.franco_rojas_20250303.viewmodel.BitcoinViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val bitcoinViewModel: BitcoinViewModel by viewModels()
    private lateinit var adapter: BitcoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = BitcoinAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        bitcoinViewModel.bitcoinData.observe(this) { response ->
            response?.let { adapter.updateList(it.serie) }
        }

        bitcoinViewModel.fetchBitcoinValues()
    }
}
