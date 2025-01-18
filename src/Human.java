import java.util.Random;

public class Human {
    Random rand = new Random();
    String name;
    String surName;
    int year;
    Integer iq;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;

    public Human() {
    }

    public Human(String name, String surName, int year) {
        this.name = name;
        this.surName = surName;
        this.year = year;
    }

    public Human(String name, String surName, int year, Human father, Human mother) {
        this(name, surName, year);
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, String surName, int year, int iq, Pet pet, Human father, Human mother, String[][] schedule) {
        this(name, surName, year, father, mother);
        if (iq >= 1 && iq <= 100) {
            this.iq = iq;
        } else {
            throw new IllegalArgumentException("iq must be between 1 and 100.");
        }
        this.pet = pet;
        this.schedule = schedule;
    }

    public void greetPet() {
        System.out.printf("Hello, %s.\n", pet.nickname);
    }

    public void describePet() {
        System.out.printf("I have an %s is %d years old, he is %s.\n", pet.species, pet.age, (pet.trickLevel > 50) ? "very sly" : "almost not sly");
    }

    public boolean feedPet(boolean petIsFed) {
        if (!petIsFed) {
            System.out.printf("Hm... I will feed %s.\n", pet.nickname);
            return true;
        }
        if (pet.trickLevel > rand.nextInt(101)) {
            System.out.printf("Hm... I will feed %s.\n", pet.nickname);
            return true;
        }
        System.out.printf("I think %s is not hungry.\n", pet.nickname);
        return false;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", mother=" + mother +
                ", father=" + father +
                ", pet=" + pet +
                '}';
    }
}

