package com.netoprojects.databasemultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.netoprojects.databasemultipletables.entities.Student
import com.netoprojects.databasemultipletables.entities.Subject

data class StudentsWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)