package spring_annotations.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_annotations.configs.ConfigSecond;
import spring_introduction.Person;
import spring_introduction.Pet;

public class TestConfigSecond {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigSecond.class);

        Pet catMy = context.getBean("catBean", Pet.class);
        System.out.println("My cat = " + catMy);
        Pet catYour = context.getBean("catBean", Pet.class);
        System.out.println("Your cat = " + catYour);
        System.out.println("Cats are same? " + (catMy == catYour));

        Person personMe = context.getBean("personBean", Person.class);
        System.out.println(personMe);
        Person personYoy = context.getBean("personBean", Person.class);
        System.out.println(personYoy);
        System.out.println("Persons are same? " + (personMe == personYoy));

        context.close();
    }
}
