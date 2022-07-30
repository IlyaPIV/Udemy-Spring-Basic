package spring_annotations.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_annotations.PersonAnno;
import spring_annotations.configs.ConfigFirst;

public class TestConfigFirst {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigFirst.class);

        PersonAnno person = context.getBean("personBean", PersonAnno.class);
        person.callYourPet();
        System.out.println(person.toString());

        context.close();
    }
}
