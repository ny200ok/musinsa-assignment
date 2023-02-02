package com.musinasa.musinsaassignment.service

import com.musinasa.musinsaassignment.mapper.toModel
import com.musinasa.musinsaassignment.model.Category
import com.musinasa.musinsaassignment.model.CategoryEntity
import com.musinasa.musinsaassignment.model.NotFoundCategoryException
import com.musinasa.musinsaassignment.repository.CategoryRepository
import org.springframework.stereotype.Service

/**
 * Created by owen.ny on 2023/02/02.
 */

@Service
class CategoryService(val categoryRepository: CategoryRepository) {
    fun get(id: Long): Category =
        categoryRepository.findById(id).orElseThrow { NotFoundCategoryException(id) }.toModel()
}