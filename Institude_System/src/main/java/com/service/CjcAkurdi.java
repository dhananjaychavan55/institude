 package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.getHibernateUtil.HibernateConfig;
import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;

public class CjcAkurdi implements CJC {

	SessionFactory sessionf=HibernateConfig.getSessionFactory();
	Scanner sc=new Scanner(System.in);
	
	public void createBatch() {
		Session session = sessionf.openSession();
		
	Batch b=new Batch();
	System.out.println("Enter Batch Name");
	b.setBname(sc.next());
	System.out.println("Enter Batch id");
	b.setBid(sc.next());
	System.out.println("Enter Batch Type");
	b.setBtype(sc.next());
	Transaction transaction = session.beginTransaction();
	System.out.println("Enter Course Id To Set This Batch");
	int cid=sc.nextInt();
	Course course = session.get(Course.class,cid );
		if(course!=null) {
			
			b.setCourse(course);
		
		}
		else {
		System.out.println("This Course Not Exist");
		}
	
	System.out.println("Enter Faculty id to Set This Batch");
	int fid=sc.nextInt();
	Faculty faculty = session.get(Faculty.class, fid);//may batch have one faculty
	if(faculty!=null) {
	
		b.setFaculty(faculty);
	}
	else 
	{
		System.out.println(fid+" :This Faculty Not Exist");
	}
	
	System.out.println("Enter Student Id To Add This Batch");
	int sid=sc.nextInt();
	Student student = session.get(Student.class, sid);
	if(student!=null) {
		
		   b.getStudents().add(student);
	}
	else {
		System.out.println("Student Not Exist");
	}
	
	session.saveOrUpdate(b);
	transaction.commit();
	
	}

	public void addFaculty() {
		Session session = sessionf.openSession();
		Transaction transaction = session.beginTransaction();
		Faculty f=new Faculty();
		System.out.println("Enter Faculty Name");
		f.setFname(sc.next());
		System.out.println("Enter Faculty Id");
		f.setFid(sc.nextInt());
		System.out.println("Enter faculty Branch");
		f.setFbranch(sc.next());
		System.out.println("Enter Batch id to Set");
		String bid=sc.next();
		Batch batch = session.get(Batch.class, bid);
		if(batch!=null) {
			
			f.getBatches().add(batch);
			
		}
		else {
			System.out.println("This Batch Not Exist");
		}
		session.saveOrUpdate(f);
		transaction.commit();
		
		
		
	}

	public void addCourse() {
		Session session = sessionf.openSession();
		Transaction transaction = session.beginTransaction();
		Course c=new Course();
		System.out.println("Enter Course Id");
		c.setCid(sc.nextInt());
		System.out.println("Enter Course Name");
		c.setCname(sc.next());
		System.out.println("Enter Course Price");
		c.setCprice(sc.nextDouble());
		
		System.out.println("Enter Student Rollno To Set Course: ");
		int roll=sc.nextInt();
		Student student = session.get(Student.class, roll);//get from database.
		if(student!=null)
		{
				c.setStudent(student);
						}
		else 
		{
			System.out.println("Add Student First");
			
		}
		session.saveOrUpdate(c);
		transaction.commit();	

	}

	public void addStudent() {
		Session session = sessionf.openSession();
		Transaction transaction = session.beginTransaction();
		Student s=new Student();
		System.out.println("Enter RollNo");
		s.setRollno(sc.nextInt());
		System.out.println("Enter Name");
		String name=sc.next();
		name=name+sc.nextLine();
		s.setName(name);
		System.out.println("Enter Course Id To Assing Student");
		int cid=sc.nextInt();
		 Course courses = session.get(Course.class, cid);
		if(courses!=null)
		{
					s.getCourses().add(courses);						
					System.out.println("Course Assined");
			
		}
		else
		{
			System.out.println("Create Course First");
		}
		
	
			System.out.println("Enter Batch Id To Assing Student");
			String bid=sc.next();
			   
			  Batch batch = session.get(Batch.class, bid);
			if (batch!=null) {
				s.getBatchs().add(batch);
				
			}
			
			
		else {
			System.out.println("Create Batches First");
			
		}
		
		session.saveOrUpdate(s);
		transaction.commit();
		
		
		
	}
	public void viewBatch() {
		Session session = sessionf.openSession();
		System.out.println("Enter Batch Id to View");
		String bid=sc.next();
		Batch batch = session.get(Batch.class, bid);
		System.out.println("Batch id: "+batch.getBid());
		System.out.println("Batch Name: "+batch.getBname());
		System.out.println("Batch Type: "+batch.getBtype());
		
		Course course = batch.getCourse();
		System.out.println("Course Id: "+course.getCid());
		System.out.println("Course Name: "+course.getCname());
		System.out.println("Course Id: "+course.getCprice());
		
					Faculty faculty = batch.getFaculty();
		System.out.println("Faculty Id: "+faculty.getFid());
		System.out.println("Faculty Name: "+faculty.getFname());
		System.out.println("Faculty Branch: "+faculty.getFbranch());
		
		List<Student> students = batch.getStudents();
		for (Student student : students) {
			System.out.println("Student Roll: "+student.getRollno());
			System.out.println("Student Name: "+student.getName());
		}
		
		session.beginTransaction().commit();
	}

	public void viewFaculty() {
		Session session = sessionf.openSession();
		System.out.println("Enter Faculty Id to View");
		int fid=sc.nextInt();
		Faculty faculty = session.get(Faculty.class, fid);
		System.out.println("Faculty Id: "+faculty.getFid());
		System.out.println("Faculty Name: "+faculty.getFname());
		System.out.println("Faculty Id: "+faculty.getFid());
		List<Batch> batches = faculty.getBatches();
		for (Batch batch : batches) {
			System.out.println("batch Id: "+batch.getBid());
			System.out.println("batch Name: "+batch.getBname());

		}
		
		
		
		session.beginTransaction().commit();

	}

	public void viewStudent() {
		Session session = sessionf.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Enter Student Id to View");
		int sid=sc.nextInt();
		Student student = session.get(Student.class, sid);
//		System.out.println(student);
		System.out.println("Student name: "+student.getName());
		System.out.println("Student Roll: "+student.getRollno());
		List<Course> courses = student.getCourses();
		for(Course c:courses) {
			System.out.println("Course Id: "+c.getCid());
			System.out.println("Course Name: "+c.getCname());
			System.out.println("Course price: "+c.getCprice());
			
		}
		List<Batch> batchs = student.getBatchs();
		for(Batch b:batchs) {
			System.out.println("Batch id: "+b.getBid());
			System.out.println("Batch Name: "+b.getBname());
			System.out.println("Batch Type: "+b.getBtype());
			System.out.println("Course Id: "+b.getCourse().getCid());
			System.out.println("Faculty Id: "+b.getFaculty().getFid());
			System.out.println("Faculty Name: "+b.getFaculty().getFname());
		}		
		transaction.commit();
	}

	public void viewCourse() {
		Session session = sessionf.openSession();
		System.out.println("Enter Course Id to View");
		int cid=sc.nextInt();
		Course course = session.get(Course.class, cid);
		System.out.println("Course id: "+course.getCid());
	System.out.println("Corse Name: "+course.getCname());
	System.out.println("Corse Price: "+course.getCprice());
	Student student = course.getStudent();
	System.out.println("Student Name: "+student.getName());
	System.out.println("Student Rollno: "+student.getRollno());

		session.beginTransaction().commit();

	}

}
