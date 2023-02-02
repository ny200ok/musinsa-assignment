package com.musinasa.musinsaassignment.service

import com.musinasa.musinsaassignment.mapper.toModel
import com.musinasa.musinsaassignment.model.Category
import com.musinasa.musinsaassignment.model.CategoryEntity
import com.musinasa.musinsaassignment.model.CategoryRequest
import com.musinasa.musinsaassignment.model.NotFoundCategoryException
import com.musinasa.musinsaassignment.repository.CategoryRepository
import org.springframework.stereotype.Service

/**
 * Created by owen.ny on 2023/02/02.
 */

@Service
class CategoryService(val categoryRepository: CategoryRepository) {
    fun get(id: Long): Category = findEntity(id).toModel()

    fun save(category: CategoryRequest): Category = category.parentId?.let {
        this.findEntity(it)
    }?.let {
        categoryRepository.save(CategoryEntity(name = category.name, parent = it)).toModel()
    } ?: categoryRepository.save(CategoryEntity(name = category.name)).toModel()

    private fun findEntity(id: Long) =
        categoryRepository.findById(id).orElseThrow { NotFoundCategoryException(id) }
}