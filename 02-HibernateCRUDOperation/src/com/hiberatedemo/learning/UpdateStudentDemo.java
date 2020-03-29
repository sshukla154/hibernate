package com.hiberatedemo.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session currentSession = factory.getCurrentSession();

		try {
			// Start the transaction
			currentSession.beginTransaction();

			// Approach 1: using session.get()
			Student student = currentSession.get(Student.class, 1);
			System.out.println(student.toString());

			// Set the required data
			student.setFirstName("Shivam");

			// Commit Transactions
			currentSession.getTransaction().commit();

			// Approach 2: Using session.createQuery("").executeUpdate()
			currentSession = factory.getCurrentSession();
			currentSession.beginTransaction();

			currentSession.createQuery(
					"update Student s" + " set s.email='sshukla@gmail.com'" + " where s.firstName like 'Seemant%'")
					.executeUpdate();

			// Commit Transactions
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
