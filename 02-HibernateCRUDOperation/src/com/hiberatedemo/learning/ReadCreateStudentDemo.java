package com.hiberatedemo.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadCreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session currentSession = factory.getCurrentSession();

		try {
			// Create a new student object
			Student student = new Student("Sara", "Donal", "saradonal@gmail.com");

			// Start the transaction
			currentSession.beginTransaction();

			// save the student object in database
			System.out.println("===> saved student === : " + student);
			currentSession.save(student);

			// commit the transaction
			currentSession.getTransaction().commit();
			System.out.println("Done !");

			// get the hibernate generated primary key
			System.out.println(student.getId());

			// Get new session and transaction
			currentSession = factory.getCurrentSession();
			currentSession.beginTransaction();
			
			// Retrieve the student based on ID
			Student getStudent = currentSession.get(Student.class, student.getId());
			System.out.println("=== : " + getStudent.toString());
			//commit the transaction
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
