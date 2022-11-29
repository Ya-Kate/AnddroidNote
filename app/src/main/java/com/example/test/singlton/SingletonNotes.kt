package com.example.test.singlton

import android.content.Context
import androidx.room.Room
import com.example.test.db.AppDataBase
import com.example.test.db.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SingletonNotes {


    @Provides
    fun provideBD(@ApplicationContext context:Context):AppDataBase {
        return  Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database-name"

//   Если убрать: .allowMainThreadQueries()  выбрасывает с программы
        ).allowMainThreadQueries().build()
    }

    @Provides
    fun provideNoteDao(appDataBase: AppDataBase) : NoteDao {
        return appDataBase.noteDao()
    }
}