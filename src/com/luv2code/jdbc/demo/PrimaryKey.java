package com.luv2code.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.entity.Student;

public class PrimaryKey {

	public static void main(String[] args) {


		SessionFactory factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Object ");
			Student std1=new Student("nayan", "kumar", "nayankumar981@gmail.com");
			Student std2=new Student("Nitesh", "kumar", "nayankumar981@gmail.com");
			Student std3=new Student("Vinod", "kumar", "nayankumar981@gmail.com");

			
			
			Transaction tx= session.beginTransaction();
			
			System.out.println("saving the studentg object");
			session.save(std1);
			session.save(std2);
			session.save(std3);
			
			tx.commit();
		}finally {
			factory.close();
		}
		
	
	}

}
