package com.example.a0247_roomdatabase.room

import android.content.Context
import android.provider.CalendarContract
import androidx.annotation.NonUiContext
import androidx.room.Database
import androidx.room.Room

@Database(entities = [Siswa :: class], version = 1, exportSchema = false)
abstract class DatabaseSiswa {
    abstract fun siswaDao() : SiswaDao

    companion object{
        @Volatile
        private var Instance: DatabaseSiswa? = null

        fun getDatabase(context: Context) : DatabaseSiswa{
            return(Instance?: synchronized(this){
                Room.databaseBuilder(context,
                    DatabaseSiswa::class.java,
                    "siswa_database")
                    .build().also {Instance}
            })
        }
    }
}