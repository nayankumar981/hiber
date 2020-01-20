package com.luv2code.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Object ");
			Student std=new Student("nayan", "kumar", "nayankumar981@gmail.com");
			Transaction tx= session.beginTransaction();
			
			System.out.println("saving the studentg object");
			session.save(std);
			
			tx.commit();
		}finally {
			factory.close();
		}
		
	}

}
