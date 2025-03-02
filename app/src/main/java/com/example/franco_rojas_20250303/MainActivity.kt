package com.example.franco_rojas_20250303

import android.content.Intent // Importar Intent
import android.content.SharedPreferences // Importar SharedPreferences
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
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        // Inflamos el layout con View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyWalletPrefs", MODE_PRIVATE)

        // Recuperamos el nombre de usuario desde SharedPreferences
        val username = sharedPreferences.getString("username", "Usuario") // Valor por defecto "Usuario"

        // Actualizamos el saludo con el nombre del usuario
        binding.tvWelcome.text = "Bienvenido, $username"




        val btnLogout = binding.btnLogout // Referencia al botón de logout

        btnLogout.setOnClickListener {
            // Limpiar SharedPreferences
            with(sharedPreferences.edit()) {
                putBoolean("isLoggedIn", false)
                apply()
            }
            // Redirigir al LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Termina MainActivity
        }

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
