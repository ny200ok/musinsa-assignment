package com.musinasa.musinsaassignment.mapper

import com.musinasa.musinsaassignment.model.Category
import com.musinasa.musinsaassignment.model.CategoryEntity

/**
 * Created by owen.ny on 2023/02/02.
 */
class CategoryMapper {
    fun convert(entity: CategoryEntity): Category = entity.let {
        Category(
            id = it.id!!,
            name = it.name,
            subCategories = it.subCategories.map { category -> convert(category) }.toList()
        )
    }
}

val categoryMapper = CategoryMapper()

fun CategoryEntity.toModel() = categoryMapper.convert(this)