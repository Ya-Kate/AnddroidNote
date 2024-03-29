package com.example.test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
//@WithFragmentBindings
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, StartFragment())
            .commit()
    }
}