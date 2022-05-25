package com.netoprojects.databasemultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.netoprojects.databasemultipletables.entities.Student
import com.netoprojects.databasemultipletables.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)
