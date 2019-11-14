package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.student.model.Course;
import com.student.model.Student;
import com.student.model.Course_;
import com.student.model.Student_;





@Transactional
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private EntityManager entityManager;
	


	public void add(Student student) {
		Assert.notNull(student);
        entityManager.persist(student);

	}
	
	public void delete(Student student) {
		entityManager.remove(student);
	}

	public List<Student> findStudentByCourseName(String courseName) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);

        Root<Student> student = query.from(Student.class);
        Join<Student, Course> course = student.join(Student_.courses);
        
        query.where(builder.equal(course.get(Course_.name), courseName));
        
        query.orderBy(builder.asc(student.get(Student_.name)));
        query.select(student);

        return entityManager.createQuery(query).getResultList();
	}

	public List<Student> findStudentNotRegistereByCourseName(String courseName) {

			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Student> query = builder.createQuery(Student.class);

	        Root<Student> student = query.from(Student.class);
	        Join<Student, Course> course = student.join(Student_.courses);
	        
	        query.where(builder.notEqual(course.get(Course_.name), courseName));
	        
	        query.orderBy(builder.asc(student.get(Student_.name)));
	        query.select(student);

	        return entityManager.createQuery(query).getResultList();
		}
	}

	


