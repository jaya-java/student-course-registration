package com.student.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "student")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @GeneratedValue(generator = "uuid-strategy")
    @Column(name = "ID")
    /* the database id of the student */
    private String id;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "COURSE_ID")})
	private Set<Course> courses = new HashSet<Course>();

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
    

}
