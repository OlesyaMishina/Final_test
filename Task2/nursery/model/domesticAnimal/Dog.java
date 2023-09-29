package model.domesticAnimal;

import java.time.LocalDate;
import java.util.List;
import model.AnimalType;
import model.Commands;

public class Dog extends DomesticAnimal {
        public Dog(int id, String animalFamily, AnimalType type, String name, LocalDate birthday, List<Commands> commands) {
        super(id, animalFamily, type, name, birthday, commands);
    }
}
