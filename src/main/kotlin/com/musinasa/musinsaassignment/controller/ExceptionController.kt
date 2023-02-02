package com.musinasa.musinsaassignment.controller

import com.musinasa.musinsaassignment.model.ErrorResponse
import com.musinasa.musinsaassignment.model.NotFoundCategoryException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created by owen.ny on 2023/02/02.
 */
@ControllerAdvice
class ExceptionController {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundCategoryException::class)
    fun handleNotFoundCategoryException(e: NotFoundCategoryException) =
        ErrorResponse(message = "Not found category: ${e.id}")
}