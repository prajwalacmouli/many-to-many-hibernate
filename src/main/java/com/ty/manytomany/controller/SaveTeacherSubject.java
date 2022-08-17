package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Subject;
import com.ty.manytomany.dto.Teacher;

public class SaveTeacherSubject {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Subject subject1 = new Subject();
		subject1.setName("Maths");
		subject1.setDays(125);

		Subject subject2 = new Subject();
		subject2.setName("Biology");
		subject2.setDays(150);

		Subject subject3 = new Subject();
		subject3.setName("Physics");
		subject3.setDays(185);

		Subject subject4 = new Subject();
		subject4.setName("English");
		subject4.setDays(195);

		Teacher teacher = new Teacher();
		teacher.setName("Shivu Kumar");
		teacher.setAge(35);

		Teacher teacher2 = new Teacher();
		teacher2.setName("Manoj Kumar ");
		teacher2.setAge(45);

		List<Subject> subject = new ArrayList<Subject>();
		subject.add(subject1);
		subject.add(subject2);
		subject.add(subject4);
		
		List<Subject> sub = new ArrayList<Subject>();
		sub.add(subject2);
		sub.add(subject3);
		sub.add(subject4);
		
		teacher.setSubject(subject);
		teacher2.setSubject(sub);

		transaction.begin();
		manager.persist(subject1);
		manager.persist(subject2);
		manager.persist(subject3);
		manager.persist(subject4);
		manager.persist(teacher);
		manager.persist(teacher2);
		transaction.commit();
	}
}