package Task2.project.model;

import java.time.LocalDate;

public class Cat extends Animal{

    public Cat(String name, LocalDate birthday) {
        super(name, birthday);
    }

    @Override
    public String toString() {
        return "Cat {" +
                "name = '" + super.getName() + '\'' +
                ", commands = " + super.getCommand() +
                ", dateOfBirth = '" + super.getBirthday() + '\'' +
                '}';
    }
    
}
