package com.luv2code.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Object ");
			Student std=new Student("T2", "kumar", "t2@gamail.com");
			Transaction tx= session.beginTransaction();
			
			System.out.println("saving the studentg object");
			System.out.println("Id before saving="+std.getId());
			session.save(std);
			System.out.println("Id after saving object="+std.getId());
			tx.commit();
			
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			System.out.println("getting with primay key="+std.getId());
			Student s=session.get(Student.class, std.getId());
			System.out.println(s);
			tx.commit();
		}finally {
			factory.close();
		}
		
	}

}
