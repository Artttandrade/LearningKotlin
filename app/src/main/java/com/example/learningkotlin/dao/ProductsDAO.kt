package com.example.learningkotlin.dao

import com.example.learningkotlin.model.Product

open class ProductsDAO {

    internal companion object {
        private var list: ArrayList<Product> = ArrayList<Product>()
    }


    fun add(product: Product) {
        list.add(product)
    }

    fun findAll(): List<Product>{

        return list

    }

}