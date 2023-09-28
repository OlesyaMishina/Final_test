package model;

import java.time.LocalDate;
import java.util.List;

public class Cat extends DomesticAnimal {
   public Cat(int id, String animalFamily, AnimalType type, String name, LocalDate birthday, List <Commands> commands) {
        super(id, animalFamily, type, name, birthday, commands);
    }

    // @Override
    // public String toString() {
    //         StringBuilder sb = new StringBuilder();
    //         sb = sb.append("\n").append(id).append(", имя: ").append((name)).append(", дата рождения: ").append(birthDate);
    //     return "Cat {" +
    //             "name = '" + super.getName() + '\'' +
    //             // ", commands = " + super.getCommand() +
    //             ", dateOfBirth = '" + super.getBirthday() + '\'' +
    //             '}';
    // } 
}
