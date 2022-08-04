package hibernate_one_to_one.tests;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

//            Employee emp = new Employee("Mihail", "Vasechkin", "HR", 855);
//            Detail detail = new Detail("London", "123456789", "miha@mail.ru");
//
//            detail.setEmployee(emp);
//            emp.setEmpDetail(detail);
//

//            session.beginTransaction();
//            session.save(emp);
//            session.getTransaction().commit();
//

            session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 4);
            System.out.println(detail.getEmployee());
            session.delete(detail);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
        System.out.println("Done!");
    }
}
