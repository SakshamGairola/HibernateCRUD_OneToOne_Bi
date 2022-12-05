package org.Saksham.util;

import org.Saksham.model.Address;
import org.Saksham.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteData {
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

            if(address!=null){
                System.out.println("Deleting Address: \n" + address + "\n");
                System.out.println("Deleting Student: \n" + address.getStudent() + "\n");

                session.delete(address);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
