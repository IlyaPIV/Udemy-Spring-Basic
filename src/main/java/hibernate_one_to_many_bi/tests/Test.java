package hibernate_one_to_many_bi.tests;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {

//            Department dept = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Zaur", "Trigulov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//            dept.addEmployeeToDepartment(emp1);
//            dept.addEmployeeToDepartment(emp2);
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            session.save(dept);
//
//            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();

            Department department = session.get(Department.class, 1);
            System.out.println(department.getEmps());

            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
        System.out.println("Done!");
    }
}