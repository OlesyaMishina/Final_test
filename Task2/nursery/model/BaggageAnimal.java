package model;

import java.time.LocalDate;
import java.util.List;

public class BaggageAnimal extends Animal{
        public BaggageAnimal(int id, String animalFamily, AnimalType type, String name, LocalDate birthday, List<Commands> commands) {
        super(id, animalFamily, type, name, birthday, commands);
    };
}
