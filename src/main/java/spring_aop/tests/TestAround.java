package spring_aop.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_aop.MyConfig;
import spring_aop.UniversityLibrary;

public class TestAround {
    public static void main(String[] args) {
        System.out.println(">>> START <<<");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary library = context.getBean("uniLibrary", UniversityLibrary.class);
        String bookName = library.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookName);

        context.close();
        System.out.println(">>> END <<<");

    }
}
