package com.example.test

import android.app.Application
import com.example.test.singlton.SingletonNotes
import kotlinx.coroutines.coroutineScope
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SingletonNotes.initBD(applicationContext)
        plantTimberTree()
    }

    private fun plantTimberTree() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}