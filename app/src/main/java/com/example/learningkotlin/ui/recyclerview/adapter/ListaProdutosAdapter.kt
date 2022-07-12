package com.example.learningkotlin.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learningkotlin.R
import com.example.learningkotlin.model.Product

class ListaProdutosAdapter(products: List<Product>, private val context: Context) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.produto_item_nome)
            val description = itemView.findViewById<TextView>(R.id.produto_item_description)
            val value = itemView.findViewById<TextView>(R.id.produto_item_valor)
            name.text = product.name;
            description.text = product.description
            value.text = product.value.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.vincula(product)
    }

    override fun getItemCount(): Int = products.size

    fun update(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products);
        notifyDataSetChanged()
    }


}
