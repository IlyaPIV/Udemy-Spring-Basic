package spring_aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(JoinPoint joinPoint, Throwable exception){

        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения " + exception);
    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(JoinPoint joinPoint){
        System.out.println("afterGetStudentsLoggingAdvice: логируем ОКОНЧАНИЕ метода getStudents()");
    }

}
