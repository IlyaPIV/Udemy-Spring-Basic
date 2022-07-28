package spring_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring_introduction.Pet;

@Component("personBean")
public class PersonAnno {

    @Autowired
    @Qualifier("dogBean")
    private Pet pet;
    @Value("${person.name}") //из файла конфигурации
    private String name;
    @Value("33")        //хард вариант
    private int age;

//    @Autowired
//    public PersonAnno(@Qualifier("catBean") Pet pet) {
//        this.pet = pet;
//    }
//
    public PersonAnno() {
        System.out.println(">> Person Bean is created");
    }

//    @Autowired
    public void setPet(Pet pet) {
        System.out.println(">> class Person: set pet");
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void callYourPet(){
        System.out.println("Hey, pet, where are you?");
        pet.say();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
