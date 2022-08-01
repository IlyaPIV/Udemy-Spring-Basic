package spring_aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

    //    long begin = System.currentTimeMillis();
        Object methodResult = null;
        try{
            methodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: exception = " + e);

            throw e;
        }
      //  long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");

      //  System.out.println("aroundReturnBookLoggingAdvice: method returnBook() worked " + (end-begin) + " ms.");
        return methodResult;

    }
}
