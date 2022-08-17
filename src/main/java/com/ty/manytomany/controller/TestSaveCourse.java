package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestSaveCourse {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Student s1 = new Student();
		s1.setName("Ram");
		s1.setAge(15);

		Student s2 = new Student();
		s2.setName("Dimple");
		s2.setAge(18);

		Student s3 = new Student();
		s3.setName("Rajesh");
		s3.setAge(20);

		Student s4 = new Student();
		s4.setName("Rau");
		s4.setAge(17);

		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

		Course course1 = new Course();
		course1.setName("Java");
		course1.setCost(34000);
		course1.setStudents(list);
		
		list.remove(2);
		list.remove(0);

		Course course2 = new Course();
		course2.setName("Python");
		course2.setCost(24000);
		course2.setStudents(list);

		transaction.begin();
		manager.persist(course1);
		manager.persist(course2);
		manager.persist(s1);
		manager.persist(s2);
		manager.persist(s3);
		manager.persist(s4);
		transaction.commit();

		System.out.println("Done!!!");

	}

}
