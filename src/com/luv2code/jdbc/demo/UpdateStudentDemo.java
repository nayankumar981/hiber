package com.luv2code.jdbc.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			int studentId=1;
			
			session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			System.out.println(" primay key="+studentId);
			//Student s=session.get(Student.class, studentId);
			System.out.println("Deleting Objcet");
			//session.delete(s);
			session.createQuery("delete from Student where id=4").executeUpdate();
			tx.commit();
			
			
			 
			 
		}finally {
			factory.close();
		}
		
	}

}
