package com.student.dao;

import java.util.List;

import com.student.model.Student;

public interface StudentDao {
	
	 /**
     * Add a user and course to the database.
     * 
     * @param studentName
     * @parm courseName
     * @return
     */
    void add(final Student student);
    /**
     * Delete a student from database
     * 
     * @param student
     * @return
     */
    void delete(final Student student);
    /**
     * Find the list of students registered by course name
     * @param courseName
     * @return
     */
    List<Student> findStudentByCourseName(final String courseName);
    /**
     * find all the students that are not registered to a specific course
     * @param courseName
     * @return
     */
    List<Student> findStudentNotRegistereByCourseName(final String courseName);

}
