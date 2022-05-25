package com.netoprojects.databasemultipletables

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.netoprojects.databasemultipletables.entities.Director
import com.netoprojects.databasemultipletables.entities.School
import com.netoprojects.databasemultipletables.entities.Student
import com.netoprojects.databasemultipletables.entities.Subject
import com.netoprojects.databasemultipletables.entities.relations.StudentSubjectCrossRef

@Database (
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {

        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}