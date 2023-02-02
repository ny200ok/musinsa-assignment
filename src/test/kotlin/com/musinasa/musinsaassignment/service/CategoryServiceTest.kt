package com.musinasa.musinsaassignment.service

import com.musinasa.musinsaassignment.model.CategoryEntity
import com.musinasa.musinsaassignment.model.CategoryRequest
import com.musinasa.musinsaassignment.repository.CategoryRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * Created by owen.ny on 2023/02/02.
 */
@SpringBootTest
class CategoryServiceTest(
    @Autowired
    val categoryRepository: CategoryRepository,
    @Autowired
    val categoryService: CategoryService
) {

    @Test
    fun `카테고리를 생성한다`() {
        // given
        val name = "카테고리"
        val category = categoryService.save(CategoryRequest(name = name))

        // when
        assertEquals(category.name, name)
    }

    @Test
    fun `카테고리를 조회한다`() {
        // given
        val parent = categoryRepository.save(CategoryEntity(name = "상위 카테고리"))

        val subCategories = listOf(
            CategoryEntity(name = "하위 카테고리1", parent = parent),
            CategoryEntity(name = "하위 카테고리2", parent = parent),
            CategoryEntity(name = "하위 카테고리2", parent = parent),
        )

        subCategories.forEach { categoryRepository.save(it) }

        // when
        val category = categoryService.get(parent.id!!)

        // then
        assertEquals(parent.id, category.id)
        assertEquals(parent.name, category.name)
        assertEquals(subCategories.size, category.subCategories.size)
    }
}