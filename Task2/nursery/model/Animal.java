package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private int id;
    private String animalFamily;
    private AnimalType type;
    private String name;
    private LocalDate birthday;
    private List<Commands> commands;

    public Animal(int id, String animalFamily, AnimalType type, String name, LocalDate birthday,
            List<Commands> commands) {
        this.id = id;
        this.animalFamily = animalFamily;
        this.type = type;
        this.name = name;
        this.birthday = birthday;
        this.commands = new ArrayList<Commands>();
    }

    public Animal() {
        this(0, null, null, null, null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    // public AnimalCommands getCommands() {
    // return commands;
    // }

    // public void setCommand(List<Commands> commands) {
    // this.commands = commands;
    // }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public AnimalType getType() {
        return type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("\n").append(id).append(" ").append(animalFamily).append(", ").append(type.toString()).append(", имя: ").append(name)
                .append(", дата рождения: ").append(birthday);
        return sb.toString();
    }
}
