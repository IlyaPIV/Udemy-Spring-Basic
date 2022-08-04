package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
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

//            Department dept = new Department("HR", 400, 900);
//            Employee emp1 = new Employee("Oleg", "Mikhailow", 640);
//            Employee emp2 = new Employee("Alena", "Sviridova", 555);
//            dept.addEmployeeToDepartment(emp1);
//            dept.addEmployeeToDepartment(emp2);
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            session.save(dept);
//
//            session.getTransaction().commit();
//
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Department department = session.get(Department.class, 2);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Department department1 = session.get(Department.class, 1);
            Department department2 = session.get(Department.class, 2);
            session.delete(department2);
            session.delete(department1);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
        System.out.println("Done!");
    }
}