package com.netoprojects.databasemultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.netoprojects.databasemultipletables.entities.School
import com.netoprojects.databasemultipletables.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
