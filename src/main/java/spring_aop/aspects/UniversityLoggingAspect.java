package spring_aop.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import spring_aop.Student;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов ПЕРЕД методом getStudents");
    }

    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){

        Student secondStudent = students.get(1);
        System.out.println(secondStudent);
        secondStudent.setNameSurname("Mr. " + secondStudent.getNameSurname());
        secondStudent.setCourse(4);
        secondStudent.setAvgGrade(secondStudent.getAvgGrade()+1);


        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение списка студентов ПОСЛЕ метода getStudents");
    }
}
