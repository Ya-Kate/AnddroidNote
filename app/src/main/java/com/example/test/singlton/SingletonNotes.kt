package com.example.test.singlton

import android.content.Context
import androidx.room.Room
import com.example.test.db.AppDataBase

object SingletonNotes {

    lateinit var db: AppDataBase

    fun initBD(context:Context) {
        db = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database-name"

//   Если убрать: .allowMainThreadQueries()  выбрасывает с программы
        ).allowMainThreadQueries().build()

    }
}