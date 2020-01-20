package com.luv2code.jdbc.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			Transaction tx= session.beginTransaction();
			
			List<Student> theStudents=session.createQuery("from Student").getResultList();
			displayStudents(theStudents);
			
			//getiing name objcet with last name using where clause in HQL
			
			theStudents=session.createQuery("from Student s where s.lastName='kumar'").list();
			displayStudents(theStudents);
			
			//Querying using or condition
			
			theStudents=session.createQuery("from Student s where s.lastName='kumar' or s.firstName='Nayan'").getResultList();
			
			displayStudents(theStudents);
			
			//Querying using like operator
			theStudents=session.createQuery("from Student s where s.email like '%1@gmail.com'").getResultList();
			displayStudents(theStudents);
			
			
			tx.commit();
		}finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student s:theStudents)
		{
			System.out.println(s);
		}
	}

}
