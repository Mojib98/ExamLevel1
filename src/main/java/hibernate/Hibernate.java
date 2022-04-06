package hibernate;

import org.hibernate.SessionFactory;

public class Hibernate {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void add(Person person) {
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                session.save(person);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }


    }

    public void ftech(Integer i) {
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                System.out.println(session.find(Person.class,i));
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
            }
        }
    }
}