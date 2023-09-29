package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Nursery implements Serializable {

    private List<Animal> nursery;

    public Nursery() {
        nursery = new ArrayList<>();
    }

    int id = 0;

    public void addAnimal(Animal animal) {
        nursery.add(animal);
    }

    public List<Animal> getAnimalList() {
        return nursery;
    }

    @Override
    public String toString() {
        return nursery.toString();
    }

    public Animal getAnimalByName(String name) {
        Animal findAnimal = null;
        for (int i = 0; i < nursery.size(); i++) {
            if (nursery.get(i).getName().equals(name))
                findAnimal = nursery.get(i);
        }
        if (findAnimal == null)
            System.out.println("Животное с именем " + name + " не найдено.");
        return findAnimal;
    }
}