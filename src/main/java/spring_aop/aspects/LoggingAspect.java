package spring_aop.aspects;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

//@Component
//@Aspect
public class LoggingAspect {

    @Before("execution(public void getBook())")
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }

    @Before("execution(void getBook(spring_aop.Book, ..))")
    public void beforeGetBookLinkAdvice(){
        System.out.println("beforeGetBookLinkAdvice: попытка получить конкретную книгу");
    }

    @Before("execution(public void spring_aop.SchoolLibrary.getBook())")
    public void beforeGetBookExtraAdvice(){
        System.out.println("beforeGetBookExtraAdvice: extra метод для SchoolLibrary");
    }

    //@Before("execution(void get*(*))")  //с любым 1 параметром
    @Before("execution(* get*(..))") //с любым кол-вом параметров
    public void beforeGetSomethingAdvice(){
        System.out.println("beforeGetSomethingAdvice: попытка что-то взять");
    }

    @Before("execution(public void returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
    }

}
