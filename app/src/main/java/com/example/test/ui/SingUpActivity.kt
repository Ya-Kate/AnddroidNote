package com.example.test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test.R
import com.example.test.databinding.FragmentAddNoteBinding
import com.example.test.databinding.FragmentSingUpBinding
import com.example.test.repositories.SharedPreferencesRepository

class SingUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        val sharedPreferencesRepository = SharedPreferencesRepository(this)
        if(sharedPreferencesRepository.getUserName() != null) {
            supportFragmentManager.beginTransaction()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerSingUp, SingUpFragment())
            .commit()
    }
}