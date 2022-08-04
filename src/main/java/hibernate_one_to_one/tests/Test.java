package hibernate_one_to_one.tests;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Ildar", "Mahmedov", "IT", 765);
            Detail detail = new Detail("Voronezh", "666222666", "loh@mail.com");
            emp.setEmpDetail(detail);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
        System.out.println("Done!");
    }
}
