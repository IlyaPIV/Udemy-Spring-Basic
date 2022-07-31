package spring_aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import spring_aop.Book;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

//    @Before("execution(public void getBook())")
//    public void beforeGetBookAdvice(){
//        System.out.println("beforeGetBookAdvice: попытка получить книгу");
//    }
//
//    @Before("execution(void getBook(spring_aop.Book, ..))")
//    public void beforeGetBookLinkAdvice(){
//        System.out.println("beforeGetBookLinkAdvice: попытка получить конкретную книгу");
//    }
//
//    @Before("execution(public void spring_aop.SchoolLibrary.getBook())")
//    public void beforeGetBookExtraAdvice(){
//        System.out.println("beforeGetBookExtraAdvice: extra метод для SchoolLibrary");
//    }
//
//    //@Before("execution(void get*(*))")  //с любым 1 параметром
//    @Before("execution(* get*(..))") //с любым кол-вом параметров
//    public void beforeGetSomethingAdvice(){
//        System.out.println("beforeGetSomethingAdvice: попытка что-то взять");
//    }
//
//    @Before("execution(public void returnBook())")
//    public void beforeReturnBookAdvice(){
//        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
//    }

    /**
     *
     */


     @Before("spring_aop.aspects.MyPointcuts.allGetMethods()")
     public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: попытка что-то взять");
     }

    @Before("spring_aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg:
                 arguments) {
                if (arg instanceof Book myBook) {
                    System.out.println("Информация о книге: название - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() + ", год издания - " + myBook.getYearOfPublication());
                } else if (arg instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет " + arg);
                }
            }
        }



        System.out.println("beforeAddLoggingAdvice: попытка что-то добавить в библиотеку");
    //    System.out.println("-----------------------------------------------");
    }
}
