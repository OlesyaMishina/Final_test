package view;

import java.util.Scanner;
import model.AnimalType;

// Собирает информацию от пользователя и передает в RestoreAnimalFromConsole
public class CollecterInfo {
    private Scanner scanner;
    private int id;
    private String name;
    private AnimalType animalType;
    private String birthday;

    public CollecterInfo() {
        scanner = new Scanner(System.in, "cp866");
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return animalType;
    }

    public void setType(AnimalType type) {
        this.animalType = type;
    }

    public AnimalType setAnimalType(int type) {
        switch (type) {
            case 1:
                animalType = AnimalType.Cat;
                break;
            case 2:
                animalType = AnimalType.Dog;
                break;
            case 3:
                animalType = AnimalType.Hamster;
                break;
            case 4:
                animalType = AnimalType.Horse;
                break;
            case 5:
                animalType = AnimalType.Donkey;
                break;
            case 6:
                animalType = AnimalType.Camel;
                break;
            default:
                System.out.println("Введите число!");
                return animalType;
        }
        return animalType;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public CollecterInfo getInfoFromUser() {
        CollecterInfo collecterInfo = new CollecterInfo();
        System.out.println("Выберите тип животного:\n" + "1 - кот\n" + "2 - собака\n" + "3 - хомяк\n" +
                "4 - лошадь\n" + "5 - осел\n" + "6 - верблюд");
        collecterInfo.setType(setAnimalType(Integer.parseInt(scanner.nextLine())));
        System.out.println("Введите имя животного:");
        collecterInfo.setName(scanner.nextLine());
        System.out.println("Введите дату рождения в формате год-месяц-день.");
        collecterInfo.setBirthday(scanner.nextLine());
        return collecterInfo;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

}
