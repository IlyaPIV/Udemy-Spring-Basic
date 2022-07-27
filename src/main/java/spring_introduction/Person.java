package spring_introduction;

public class Person {
    private Pet pet;

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

    public void callYourPet(){
        System.out.println("Hey, pet, where are you?");
        pet.say();
    }
}
