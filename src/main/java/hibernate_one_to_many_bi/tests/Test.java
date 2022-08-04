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

//            Department dept = new Department("HR", 400, 900);
//            Employee emp1 = new Employee("Oleg", "Mikhailow", 640);
//            Employee emp2 = new Employee("Alena", "Sviridova", 555);
//            Employee emp3 = new Employee("Vasia", "Loshkow", 450);
//            dept.addEmployeeToDepartment(emp1);
//            dept.addEmployeeToDepartment(emp2);
//            dept.addEmployeeToDepartment(emp3);
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            session.save(dept);
//
//            session.getTransaction().commit();

            //****************************************

            session = factory.getCurrentSession();
            session.beginTransaction();

            Department department = session.get(Department.class, 3);
            System.out.println("Department:");
            System.out.println(department);

            session.getTransaction().commit();

            System.out.println("Employees:");
            System.out.println(department.getEmps());

        } finally {
            factory.close();
            session.close();
        }
        System.out.println("Done!");
    }
}