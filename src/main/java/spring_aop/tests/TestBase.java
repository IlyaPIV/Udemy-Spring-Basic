package spring_aop.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_aop.Book;
import spring_aop.SchoolLibrary;
import spring_aop.UniversityLibrary;
import spring_aop.MyConfig;

public class TestBase {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

     //   Book book = context.getBean("book", Book.class);


        UniversityLibrary uniLibrary = context.getBean("uniLibrary", UniversityLibrary.class);
        uniLibrary.getBook();
//        uniLibrary.returnBook();
        uniLibrary.getMagazine();
//        uniLibrary.getBook("Война и мир");
//        uniLibrary.getBook(book);

//        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();
//        schoolLibrary.returnBook();

        context.close();
    }
}
