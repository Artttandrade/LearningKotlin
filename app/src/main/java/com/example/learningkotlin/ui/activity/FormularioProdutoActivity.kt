package com.example.learningkotlin.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.learningkotlin.R
import com.example.learningkotlin.dao.ProductsDAO
import com.example.learningkotlin.model.Product
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    private val productsDAO = ProductsDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val salvarButton: Button = findViewById(R.id.buttonSalvar)

        salvarButton.setOnClickListener {
            val newProduct = createNewProduct()
            productsDAO.add(newProduct);

            Log.i("FormularioProduto", "onCreate: ${productsDAO.findAll()}")
            finish()
        }

    }

    private fun createNewProduct(): Product {
        val nomeField: EditText = findViewById<EditText>(R.id.activity_formulario_produto_nome)
        val descriptionField: EditText = findViewById<EditText>(R.id.activity_formulario_produto_description)
        val valorField: EditText = findViewById<EditText>(R.id.activity_formulario_produto_valor)

        val nome: String = nomeField.text.toString()
        val description: String = descriptionField.text.toString()
        val valor: BigDecimal = if (valorField.toString().isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorField.text.toString())
        }

        return Product(
            name = nome,
            description = description,
            value = valor
        )
    }

}