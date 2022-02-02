package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Batch {

	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", btype=" + btype + ", bname=" + bname + ", course=" + course + ", faculty="
				+ faculty + ", students=" + students + "]";
	}
	@Id
	private String bid;
	private String btype;
	private String bname;
	@OneToOne(cascade = CascadeType.ALL)
	private Course course;
	@ManyToOne(cascade = CascadeType.ALL)
	private Faculty faculty;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student>students=new ArrayList<Student>();
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
