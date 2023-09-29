package model.baggageAnimal;

import java.time.LocalDate;
import java.util.List;
import model.AnimalType;
import model.Commands;

public class Horse extends BaggageAnimal {
    public Horse(int id, String animalFamily, AnimalType type, String name, LocalDate birthday,
            List<Commands> commands) {
        super(id, animalFamily, type, name, birthday, commands);
    }
}
