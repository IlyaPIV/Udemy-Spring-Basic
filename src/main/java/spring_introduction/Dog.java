package spring_introduction;

public class Dog implements Pet{
    public void say() {
        System.out.println("Bow-wow!");
    }

    public void init(){
        System.out.println("!!! class Dog - init method");
    }

    public void destroy(){
        System.out.println("!!! class Dog - destroy method");
    }
}
