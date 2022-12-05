package org.Saksham.util;

import org.Saksham.model.Address;
import org.Saksham.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernateCfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            Student student1 = new Student("Saksham");
            Student student2 = new Student("Gairola");

            Address address1 = new Address("city1", "state1");
            Address address2 = new Address("city2", "state2");

            student1.setStudentAddress(address1);
            student2.setStudentAddress(address2);

            session.beginTransaction();

            session.save(student1);
            session.save(student2);
//            session.save(address1);
//            session.save(address2);

            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sessionFactory.close();
        }
    }
}

