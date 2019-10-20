package com.example.assignment_9.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.assignment_9.data.vos.*
import com.example.assignment_9.persistence.daos.MovieDao
import com.example.assignment_9.persistence.typeconverters.GenreListTypeConverter
import com.example.assignment_9.utils.DB_NAME

@Database(
    entities = [MovieVO::class],
    version = 6,
    exportSchema = false
)
@TypeConverters(GenreListTypeConverter::class)
abstract class MovieDB : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var instances: MovieDB? = null
        fun getInstance(context: Context): MovieDB {
            if (instances == null) {
                instances = Room.databaseBuilder(context, MovieDB::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build()
            }
            return instances!!
        }
    }
}