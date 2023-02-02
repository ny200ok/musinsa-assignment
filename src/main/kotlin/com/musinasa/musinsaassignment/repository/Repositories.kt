package com.musinasa.musinsaassignment.repository

import com.musinasa.musinsaassignment.model.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by owen.ny on 2023/02/02.
 */
@Repository
interface CategoryRepository : JpaRepository<CategoryEntity, Long>