package com.musinasa.musinsaassignment.model

/**
 * Created by owen.ny on 2023/02/02.
 */

data class ErrorResponse(val message: String)
class NotFoundCategoryException(val id: Long) : RuntimeException()