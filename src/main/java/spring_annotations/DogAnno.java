package spring_annotations;

import org.springframework.stereotype.Component;
import spring_introduction.Pet;

@Component("dogBean")
public class DogAnno implements Pet {

    public void say() {
        System.out.println("Bow-wow!");
    }

    public void init(){
        System.out.println("!!! class Dog - init method");
    }

    public void destroy(){
        System.out.println("!!! class Dog - destroy method");
    }
}
