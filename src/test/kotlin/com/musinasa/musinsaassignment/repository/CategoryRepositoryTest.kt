package com.musinasa.musinsaassignment.repository

import com.musinasa.musinsaassignment.model.CategoryEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * Created by owen.ny on 2023/02/02.
 */
@SpringBootTest
class CategoryRepositoryTest(
    @Autowired
    val categoryRepository: CategoryRepository
) {

    @Test
    fun `단건 조회 테스트`() {
        // given
        val category = categoryRepository.save(CategoryEntity(name = "테스트 카테고리 1"))
        // when
        val result = categoryRepository.findById(category.id!!).get()
        // then
        assertEquals(result.id, category.id)
        assertEquals(result.name, category.name)
    }

    @Test
    fun `하위 카테고리 조회 테스트`() {
        // given
        val parent = categoryRepository.save(CategoryEntity(name = "상위 카테고리"))

        val subCategories = listOf(
            CategoryEntity(name = "하위 카테고리1", parent = parent),
            CategoryEntity(name = "하위 카테고리2", parent = parent),
            CategoryEntity(name = "하위 카테고리2", parent = parent),
        )

        subCategories.forEach { categoryRepository.save(it) }

        // when
        val result = categoryRepository.findById(parent.id!!).get()
        // then
        assertEquals(result.name, parent.name)
    }
}