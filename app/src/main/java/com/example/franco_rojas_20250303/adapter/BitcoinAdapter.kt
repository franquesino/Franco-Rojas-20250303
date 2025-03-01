package com.example.franco_rojas_20250303.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.franco_rojas_20250303.R
import com.example.franco_rojas_20250303.model.BitcoinSerie

class BitcoinAdapter(private var bitcoinList: List<BitcoinSerie>) :
    RecyclerView.Adapter<BitcoinAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtFecha: TextView = view.findViewById(R.id.txtFecha)
        val txtValor: TextView = view.findViewById(R.id.txtValor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bitcoin, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = bitcoinList[position]
        holder.txtFecha.text = item.fecha
        holder.txtValor.text = item.valor.toString()
    }

    override fun getItemCount() = bitcoinList.size

    fun updateList(newList: List<BitcoinSerie>) {
        bitcoinList = newList
        notifyDataSetChanged()
    }
}
