package spring_aop.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_aop.Library;
import spring_aop.MyConfig;

public class TestBase {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Library library = context.getBean("libraryBean", Library.class);
        library.getBook();

        context.close();
    }
}
