package spring_introduction.tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.Pet;

public class TestPets {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();

        context.close();
    }
}
