package spring_aop.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_aop.MyConfig;
import spring_aop.Student;
import spring_aop.University;

import java.util.List;

public class TestAfterReturning {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();
        List<Student> students = university.getStudents();
        System.out.println(students);

        context.close();
    }
}
