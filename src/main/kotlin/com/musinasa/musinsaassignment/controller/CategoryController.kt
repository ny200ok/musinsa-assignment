package com.musinasa.musinsaassignment.controller

import com.musinasa.musinsaassignment.model.Category
import com.musinasa.musinsaassignment.model.CategoryRequest
import com.musinasa.musinsaassignment.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

/**
 * Created by owen.ny on 2023/02/02.
 */
@RestController
@RequestMapping("/v1/categories")
class CategoryController(val categoryService: CategoryService) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = categoryService.get(id)

    @PostMapping
    fun create(@RequestBody category: CategoryRequest) = categoryService.save(category).let {
        ResponseEntity.created(
            URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().build()
                    .toUriString() + "/v1/categories/${it.id}"
            )
        ).body(it)
    }
}