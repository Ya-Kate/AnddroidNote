package com.example.test.Validation

import android.util.Patterns
import com.example.test.R

object EmailValidator {
    fun validateEmail(email: String): ValidationResult {
        return when {
            Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                Valid
            }
            email.isNotBlank() -> {
                Invalid(R.string.email_blank)
            }
            else -> Invalid(R.string.email_invalid)
        }
    }
}