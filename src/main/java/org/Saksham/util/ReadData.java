package org.Saksham.util;

import org.Saksham.model.Address;
import org.Saksham.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernateCfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            int addressID = 2;
            session.beginTransaction();

            Address address = session.get(Address.class, addressID);
            System.out.println("Address Details: \n" + address);
            System.out.println("Student Info: \n" + address.getStudent());

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
