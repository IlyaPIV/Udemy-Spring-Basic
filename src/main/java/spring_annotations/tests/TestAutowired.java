package spring_annotations.tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_annotations.CatAnno;
import spring_annotations.PersonAnno;

public class TestAutowired {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

        PersonAnno person = context.getBean("personBean", PersonAnno.class);
        person.callYourPet();

        System.out.println(person.getName() + " / "+person.getAge());

        context.close();
    }
}
