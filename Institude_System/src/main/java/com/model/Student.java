package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	private int rollno;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> courses=new ArrayList<Course>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Batch>batchs=new ArrayList<Batch>();

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Batch> getBatchs() {
		return batchs;
	}

	public void setBatchs(List<Batch> batchs) {
		this.batchs = batchs;
	}

	@Override
	public String toString() {
		return "Rollno=" + rollno + " Name=" + name + " Courses=" + courses + " Batchs=" + batchs;
	}

	
	
	
	
}
