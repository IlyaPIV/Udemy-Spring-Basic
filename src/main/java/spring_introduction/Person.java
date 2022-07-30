package spring_introduction;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    private Pet pet;
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

    public Person(Pet pet) {
        this.pet = pet;
    }

    public Person() {
        System.out.println(">> Person Bean is created");
    }

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
