package com.musinasa.musinsaassignment.controller

import com.musinasa.musinsaassignment.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by owen.ny on 2023/02/02.
 */
@RestController("/v1/categories")
@RequestMapping("/v1/categories")
class CategoryController(val categoryService: CategoryService) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = categoryService.get(id)
}