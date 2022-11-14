package com.example.test.repositories

import android.content.Context
import android.widget.EditText
import androidx.core.content.edit

private const val USER_PREFERENCES = "user_preferences"
private const val GLOBAL_PREFERENCES = "global_preferences"

private const val USER_NAME = "user_name"
private const val USER_PASSWORD = "user_password"
private const val USER_MAIL = "user_mail"

class SharedPreferencesRepository(private val context:Context) {

    private val userPreferences =
        context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

    private val globalPreferences =
        context.getSharedPreferences(GLOBAL_PREFERENCES, Context.MODE_PRIVATE)

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

    fun setUserMail(userName: String) {
        userPreferences.edit {
            putString(USER_MAIL, userName)
        }
    }

    fun getUserName():String? {
        return userPreferences.getString(USER_NAME, null)
    }

    fun getUserPassword():String? {
        return userPreferences.getString(USER_PASSWORD, null)
    }

    fun getUserMail() :String? {
        return userPreferences.getString(USER_MAIL, null)
    }

    fun logout() {
        userPreferences.edit {
            clear()
        }
    }
}