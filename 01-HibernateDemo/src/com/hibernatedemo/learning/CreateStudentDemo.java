package com.hibernatedemo.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session currentSession = factory.getCurrentSession();

		try {
			// Create the Student Object
			Student student = new Student("Seemant", "Shukla", "seemantshukla@gmail.com");

			// Start the transaction
			currentSession.beginTransaction();
			
			// save the student object in database
			currentSession.save(student);
			
			// commit the transaction
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
