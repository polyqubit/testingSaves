package pets;
import java.util.*;

import pkg.Pet;

public class Fish implements Pet {
    String name;
    int age;
    Random rand = new Random();
    ArrayList<String> tricks = new ArrayList<>();
    public Fish() {
        this("Hubert",0);
    }
    public Fish(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private void p(Object o) {System.out.print(o);}
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void teach(String teachThis) {
        tricks.add(teachThis);
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void interact() {

    }
	public void trick() {
        if(!tricks.isEmpty()) {

        }
        else {
            p(name+" stares at you, confused.\n");
        }
    }
    public String toString() {
        return "Fish";
    } 
}