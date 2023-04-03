package com.example.test.validation

sealed class ValidationResult
    object Valid: ValidationResult()
    class Invalid(val errorText: Int) :ValidationResult()
