package spring_annotations.tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_annotations.CatAnno;
import spring_introduction.Person;

public class TestAutowired {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();
    }
}
