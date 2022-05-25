package com.netoprojects.databasemultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.netoprojects.databasemultipletables.entities.Director
import com.netoprojects.databasemultipletables.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)