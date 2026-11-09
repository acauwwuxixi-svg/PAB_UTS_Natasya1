package com.example.uts_catatanharian.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uts_catatanharian.data.dao.NoteDao_137
import com.example.uts_catatanharian.data.dao.UserDao_137
import com.example.uts_catatanharian.data.entity.NoteEntity_137
import com.example.uts_catatanharian.data.entity.UserEntity_137

@Database(entities = [UserEntity_137::class, NoteEntity_137::class], version = 1, exportSchema = false)
abstract class AppDatabase_137 : RoomDatabase() {
    abstract fun userDao_137(): UserDao_137
    abstract fun noteDao_137(): NoteDao_137

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase_137? = null

        fun getDatabase_137(context: Context): AppDatabase_137 {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase_137::class.java,
                    "catatan_harian_db_137"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
