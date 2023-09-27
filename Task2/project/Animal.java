package Task2.project;

import java.time.LocalDate;

import javax.xml.crypto.Data;

public abstract class Animal {
    private int id;
    private Counter count;
    private String name;
    private LocalDate birthday; 
    private AnimalCommands command;
    private AnimalType type;

    public Animal(String name, LocalDate birthday){
        this.name=name;
        this.birthday=birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Counter getCount() {
        return count;
    }

    public void setCount(Counter count) {
        this.count = count;
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

    public AnimalCommands getCommand() {
        return command;
    }

    public void setCommand(AnimalCommands command) {
        this.command = command;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }
    
    public AnimalType getType() {
        return type;
    }
}
