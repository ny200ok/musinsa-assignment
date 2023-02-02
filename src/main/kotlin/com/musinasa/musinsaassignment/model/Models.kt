package com.musinasa.musinsaassignment.model

/**
 * Created by owen.ny on 2023/02/02.
 */
data class Category(
    val id: Long,
    val name: String,
    val subCategories: List<Category>
)