package com.example.learningkotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
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
            val nomeField: EditText = findViewById<EditText>(R.id.nome)
            val descriptionField: EditText = findViewById<EditText>(R.id.description)
            val valorField: EditText = findViewById<EditText>(R.id.valor)

            val nome: String = nomeField.text.toString()
            val description: String = descriptionField.text.toString()
            val valor: BigDecimal = if(valorField.toString().isBlank()){
                BigDecimal.ZERO
            } else {
                BigDecimal(valorField.text.toString())
            }

            val newProduct = Product(
                name = nome,
                description = description,
                value = valor
            )
            Log.i("FormularioProduto", "onCreate: $newProduct")



            productsDAO.add(newProduct);

            Log.i("FormularioProduto", "onCreate: ${productsDAO.findAll()}")
           // this.finish()
            finish()
        }

    }

}