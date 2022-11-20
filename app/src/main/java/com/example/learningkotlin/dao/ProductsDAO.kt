package com.example.learningkotlin.dao

import com.example.learningkotlin.model.Product
import java.math.BigDecimal

open class ProductsDAO {

    internal companion object {
        private var list = mutableListOf<Product>(
            Product(
                name = "Salada de Frutas",
                description = "Laranja, maça e uva",
                value = BigDecimal("5.00")
            )
        )
    }


    fun add(product: Product) {
        list.add(product)
    }

    fun findAll(): List<Product> {

        return list

    }

}