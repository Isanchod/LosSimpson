package edu.iesam.lossimpson.features.characters.domain

sealed class ErrorApp: Throwable() {
    object ApiError : ErrorApp()
    object NetworkError : ErrorApp()
}