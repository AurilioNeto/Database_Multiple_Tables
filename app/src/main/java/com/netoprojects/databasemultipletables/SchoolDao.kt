package com.netoprojects.databasemultipletables

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.netoprojects.databasemultipletables.entities.Director
import com.netoprojects.databasemultipletables.entities.School
import com.netoprojects.databasemultipletables.entities.Student
import com.netoprojects.databasemultipletables.entities.Subject
import com.netoprojects.databasemultipletables.entities.relations.SchoolAndDirector
import com.netoprojects.databasemultipletables.entities.relations.SchoolWithStudents
import com.netoprojects.databasemultipletables.entities.relations.StudentSubjectCrossRef
import com.netoprojects.databasemultipletables.entities.relations.StudentsWithSubjects
import com.netoprojects.databasemultipletables.entities.relations.SubjectWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectOfStudents(studentName: String): List<StudentsWithSubjects>
}