package spring_introduction.tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.Dog;
import spring_introduction.Person;
import spring_introduction.Pet;

public class TestPerson {
    public static void main(String[] args) {

        //oldSchoolMethod();  //classic java

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        withoutDependencyInjection(context);

        context.close();
    }

    /**
    * метод без спринга
     **/
    private static void oldSchoolMethod(){
        Pet pet = new Dog();
        Person person = new Person(pet);
        person.callYourPet();
    }

    /**
    * ручное добавление зависимостей
     **/
    private static void withoutDependencyInjection(ClassPathXmlApplicationContext context){
        Pet pet = context.getBean("myPet", Pet.class);

        Person person = new Person(pet);
        person.callYourPet();
    }
}
