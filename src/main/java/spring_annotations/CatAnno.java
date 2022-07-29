package spring_annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring_introduction.Pet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("catBean")
@Scope("singleton")
public class CatAnno implements Pet {
    public void say() {
        System.out.println("Meow-meow!");
    }


    @PostConstruct
    public void init(){
        System.out.println("!!! class Cat - init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("!!! class Cat - destroy method");
    }
}
