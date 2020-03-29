package com.hiberatedemo.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session currentSession = factory.getCurrentSession();

		try {
			// Create the 3 Students Object
			Student student1 = new Student("Seemant_1", "Shukla", "seemantshukla1@gmail.com");
			Student student2 = new Student("Seemant_2", "Shukla", "seemantshukla2@gmail.com");
			Student student3 = new Student("Seemant_3", "Shukla", "seemantshukla3@gmail.com");

			// Start the transaction
			currentSession.beginTransaction();
			
			// save the student object in database
			currentSession.save(student1);
			currentSession.save(student2);
			currentSession.save(student3);
			
			// commit the transaction
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
