package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Zaur", 5);
//            Child child2 = new Child("Masha", 6);
//            Child child3 = new Child("Petia", 6);
//            section1.addChild(child1);
//            section1.addChild(child2);
//            section1.addChild(child3);
//
//            Section section2 = new Section("Dance");
//            Child child4 = new Child("Olya", 9);
//            section2.addChild(child2);
//            section2.addChild(child4);
//
//            Section section3 = new Section("Swimming");
//            Child child5 = new Child("Igor", 11);
//            section3.addChild(child3);
//            section3.addChild(child5);
//
//
//            session.beginTransaction();
//            session.persist(section1);
//            session.persist(section2);
//            session.persist(section3);
//
//            session.getTransaction().commit();

            //*************************************

            session = factory.getCurrentSession();
            session.beginTransaction();

            Section section = session.get(Section.class, 1);
            System.out.println(section);
            System.out.println(section.getChildren());

            Child child = session.get(Child.class, 3);
            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();

            //***************************************

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.delete(session.get(Section.class, 2));

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
        System.out.println("Done!");
    }
}
