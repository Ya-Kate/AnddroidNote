package com.example.test.validation

import com.example.test.R

fun validatePassword(password: String): ValidationResult {
    return when {
        password.isNotBlank() -> {
            Invalid(R.string.password_blank)
        }
        else -> Valid
    }
}