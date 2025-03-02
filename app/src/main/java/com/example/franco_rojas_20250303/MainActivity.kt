package com.example.franco_rojas_20250303

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.franco_rojas_20250303.adapter.BitcoinAdapter
import com.example.franco_rojas_20250303.viewmodel.BitcoinViewModel
import com.example.franco_rojas_20250303.databinding.ActivityMainBinding // Import ViewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val bitcoinViewModel: BitcoinViewModel by viewModels()
    private lateinit var adapter: BitcoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflamos el layout con View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = BitcoinAdapter(emptyList())

        // Usamos binding.recyclerView en lugar de recyclerView directamente
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        bitcoinViewModel.bitcoinData.observe(this) { response ->
            response?.let { adapter.updateList(it.serie) }
        }

        bitcoinViewModel.fetchBitcoinValues()
    }
}
