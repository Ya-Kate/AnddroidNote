package com.example.test.repositories

import android.content.Context
import android.widget.EditText
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val USER_PREFERENCES = "user_preferences"
private const val USER_NAME = "user_name"
private const val USER_PASSWORD = "user_password"

@Singleton
class SharedPreferencesRepository @Inject constructor(@ApplicationContext context:Context) {

    private val userPreferences =
        context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

    fun setUserName(userName:String) {
        userPreferences.edit {
            putString(USER_NAME, userName)
        }
    }

    fun setUserPassword(userPassword:String) {
        userPreferences.edit {
            putString(USER_PASSWORD, userPassword)
        }
    }

    fun getUserName():String? {
        return userPreferences.getString(USER_NAME, null)
    }

    fun getUserPassword():String? {
        return userPreferences.getString(USER_PASSWORD, null)
    }

    fun logout() {
        userPreferences.edit {
            clear()
        }
    }
}