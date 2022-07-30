package spring_aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

//    @Pointcut("execution(* get*())")
//    private void allGetMethods(){}
//
//
//
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: попытка что-то взять");
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice(){
//        System.out.println("beforeGetSecurityAdvice: проверка прав на возможность получения чего-либо");
//    }

    @Pointcut("execution(* spring_aop.UniversityLibrary.get*())")
    private void allGetMethodsUniLibrary(){}

    @Before("allGetMethodsUniLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("!beforeGetLoggingAdvice: writing Log #1");
    }

    @Pointcut("execution(* spring_aop.UniversityLibrary.return*())")
    private void allReturnMethodsUniLibrary(){}

    @Before("allReturnMethodsUniLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("!beforeReturnLoggingAdvice: writing Log #2");
    }

    @Pointcut("execution(* spring_aop.UniversityLibrary.add*())")
    private void allAddMethodsUniLibrary(){}

    @Before("allAddMethodsUniLibrary()")
    public void beforeAddLoggingAdvice(){
        System.out.println("!beforeAddLoggingAdvice: writing Log #3");
    }

    @Pointcut("allGetMethodsUniLibrary() || allReturnMethodsUniLibrary()")
    private void allGetAndReturnMethodsUniLibrary(){}

    @Before("allGetAndReturnMethodsUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("!beforeGetAndReturnLoggingAdvice: writing Log #4");
    }

    /*
    *
     */

    @Pointcut("execution(* spring_aop.UniversityLibrary.*(..))")
    private void allUniLibraryMethods(){}

    @Pointcut("execution(* spring_aop.UniversityLibrary.returnMagazine(..))")
    private void returnMagazineUniLibraryMethod(){}

    @Pointcut("allUniLibraryMethods() && !returnMagazineUniLibraryMethod()")
    private void allMethodsExceptReturnMagazineUniLibrary(){}

    @Before("allMethodsExceptReturnMagazineUniLibrary()")
    public void allMethodsExceptReturnMagazineAdvice(){
        System.out.println("!!!allMethodsExceptReturnMagazineAdvice: writing log #5");
    }
}
