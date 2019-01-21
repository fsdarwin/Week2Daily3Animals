package com.example.week2daily3animals;

public class DBAnimal {

    //Class variables
    private int id;
    private Animal animal;

    //Constructor
    public DBAnimal(int id, Animal animal) {
        this.id = id;
        this.animal = animal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
