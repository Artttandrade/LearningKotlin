package com.example.learningkotlin.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningkotlin.R
import com.example.learningkotlin.dao.ProductsDAO
import com.example.learningkotlin.model.Product
import com.example.learningkotlin.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView;
    val productsDAO = ProductsDAO()

    fun createListOfProducts(): ArrayList<Product> {
        var list: ArrayList<Product> = ArrayList()

        list.add(
            Product(
                name = "Uva",
                description = "Pequeno objeto doce",
                value = BigDecimal("10.50")
            )
        )

        list.add(
            Product(
                name = "Maçã",
                description = "Crocante",
                value = BigDecimal("2.50")
            )
        )

        list.add(
            Product(
                name = "Banana",
                description = "Cacho",
                value = BigDecimal("10.20")
            )
        )

        return list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        fab.setOnClickListener {
            Log.i("MainActivity", "FAB")
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "OnStop")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "OnResume")
        Log.i("MainActivity", "${productsDAO.findAll()}")
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(products = this.productsDAO.findAll(), context = this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "OnStart")
    }
}