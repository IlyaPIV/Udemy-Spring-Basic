package spring_aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* spring_aop.UniversityLibrary.get*())")
    public void allGetMethods(){}

    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){}

}
