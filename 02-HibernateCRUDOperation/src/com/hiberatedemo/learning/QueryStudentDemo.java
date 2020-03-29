package com.hiberatedemo.learning;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session currentSession = factory.getCurrentSession();

		try {
			// Start the transaction
			currentSession.beginTransaction();

			// Query All Students
			List<Student> studentList = currentSession.createQuery("from Student").list();
			displayStudent(studentList);

			// Query All Students where lastName = Duck
			studentList = currentSession.createQuery("from Student s where s.lastName = 'Duck'").list();
			displayStudent(studentList);

			// Query All Students where firstName = Duck
			studentList = currentSession.createQuery("from Student s where s.firstName = 'Sara'").list();
			displayStudent(studentList);

			// Query All Students where firstName = Daffy or lastName = Shukla
			studentList = currentSession.createQuery("from Student s where s.firstName = 'Daffy' OR s.lastName = 'Shukla'").list();
			displayStudent(studentList);

			// Query All Students where firstName = Duck
			studentList = currentSession.createQuery("from Student s where s.firstName like 'Seemant%'").list();
			displayStudent(studentList);

			// Commit Transactions
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	private static void displayStudent(List<Student> studentList) {
		studentList.forEach(student -> System.out.println(student.toString()));
	}

}
