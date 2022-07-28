package spring_annotations.tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_annotations.CatAnno;

public class ConfigWithAnnotations {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

        CatAnno cat = context.getBean("catBean", CatAnno.class);
        cat.say();

        context.close();
    }
}
