package spring_annotations;

import org.springframework.stereotype.Component;
import spring_introduction.Pet;

@Component("catBean")
public class CatAnno implements Pet {
    public void say() {
        System.out.println("Meow-meow!");
    }

    public void init(){
        System.out.println("!!! class Cat - init method");
    }

    public void destroy(){
        System.out.println("!!! class Cat - destroy method");
    }
}
