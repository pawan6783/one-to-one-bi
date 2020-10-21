package com.example.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int id = 2;

			session.beginTransaction();
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);
			
			if(tempInstructorDetail != null) {
				session.delete(tempInstructorDetail);
				session.getTransaction().commit();
			}
			else {
				System.out.println("Object not found");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		finally {
			session.close();
			factory.close();
		}
	}

}
