package com.student.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "course")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @NotNull
    @GeneratedValue(generator = "uuid-strategy")
    @Column(name = "ID")
    /* the database id of the student */
    private String id;
	
	@Column(name="NAME")
	private String name;

	
	public Course() {
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
	

}
