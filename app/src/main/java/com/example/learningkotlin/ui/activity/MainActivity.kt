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
import com.example.learningkotlin.databinding.ActivityMainBinding
import com.example.learningkotlin.model.Product
import com.example.learningkotlin.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView;
    private val productsDAO = ProductsDAO()
    private val adapter = ListaProdutosAdapter(context = this, products = productsDAO.findAll())
    private val binding by lazy {
        Log.i("binding","initializating" )
        ActivityMainBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //val binding = ActivityMainBinding.inflate(layoutInflater)

        Log.i("binding","On Create" )
        setContentView(binding.root)
        configRecyclerView()
        configFab()

    }

    private fun configFab() {
        val fab = binding.floatingActionButton // findViewById<FloatingActionButton>(R.id.floatingActionButton)

        fab.setOnClickListener {
            Log.i("MainActivity", "FAB")
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

//    override fun onPause() {
//        super.onPause()
//        Log.i("MainActivity", "OnPause")
//    }

//    override fun onStop() {
//        super.onStop()
//        Log.i("MainActivity", "OnStop")
//    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "OnResume")
        Log.i("MainActivity", "${productsDAO.findAll()}")
        adapter.update(productsDAO.findAll())
    }

    private fun configRecyclerView() {
        Log.i("binding","configRecyclerView" )
        recyclerView = binding.recyclerView // findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        // recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "OnStart")
    }
}