package com.musinasa.musinsaassignment.controller

import com.musinasa.musinsaassignment.model.CategoryEntity
import com.musinasa.musinsaassignment.repository.CategoryRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

/**
 * Created by owen.ny on 2021/04/02.
 */
@SpringBootTest
class CategoryControllerTest(
    @Autowired val controller: CategoryController,
    @Autowired val errorController: ExceptionController,
    @Autowired val categoryRepository: CategoryRepository
) {
    lateinit var mvc: MockMvc

    @BeforeEach
    fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(controller)
            .setControllerAdvice(errorController)
            .build()
    }

    @Test
    fun `카테고리를 조회하는데 성공하면 200 코드를 반환한다`() {
        // given
        val category = categoryRepository.save(CategoryEntity(name = "테스트 카테고리 1"))

        // when
        // then
        mvc.perform(
            get("/v1/categories/${category.id}")
        ).andExpect(status().isOk)
    }

    @Test
    fun `존재하지 않는 카테고리를 조회하면 404 코드를 반환한다`() {
        // given
        val unknownId = 999

        // when
        // then
        mvc.perform(
            get("/v1/categories/$unknownId")
        ).andExpect(status().isNotFound)
    }

}
