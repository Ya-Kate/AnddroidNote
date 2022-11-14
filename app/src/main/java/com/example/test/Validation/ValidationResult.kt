package com.example.test.Validation

sealed class ValidationResult
    object Valid: ValidationResult()
    class Invalid(val errorText: Int) :ValidationResult()
