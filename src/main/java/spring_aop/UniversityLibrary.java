package spring_aop;

import org.springframework.stereotype.Component;

@Component("uniLibrary")
public class UniversityLibrary extends AbstractLibrary{

   // @Override
    public void getBook(){
        System.out.println("Мы берём книгу из университетской библиотеки");
        System.out.println("--------------------------------------------");
    }

//    public void getBook(String bookName){
//        System.out.printf("Мы берём книгу \"%s\" из университетской библиотеки\n", bookName);
//    }
//
//    public void getBook(Book book){
//        System.out.printf("Мы берём книгу \"%s\" из университетской библиотеки\n", book.getName());
//    }

    @Override
    public void returnBook() {
        System.out.println("Мы возвращаем книгу в университетскую библиотеку");
        System.out.println("------------------------------------------------");
    }

    public void addBook(String person_name, Book book){
        System.out.println("Мы добавляем книгу в университетскую библиотеку");
        System.out.println("-----------------------------------------------");
    }

    public void getMagazine(){
        System.out.println("Мы берём журнал из университетской библиотеки");
        System.out.println("---------------------------------------------");
    }

    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в университетскую библиотеку");
        System.out.println("-------------------------------------------------");
    }

    public void addMagazine(){
        System.out.println("Мы добавляем журнал в университетскую библиотеку");
        System.out.println("------------------------------------------------");
    }
}
