package Task2.project.view;
import java.util.Scanner;
import Task2.project.model.AnimalType;

public class CollecterInfo {

    private Scanner scanner;
    private int id;
    private String name;
    private AnimalType animalType;

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

    public CollecterInfo getInfoFromUser() {
        CollecterInfo collecterInfo = new CollecterInfo();
        System.out.println("Введите имя животного:");
        collecterInfo.setName(scanner.nextLine());
        System.out.println("Выберите тип животного:");
        collecterInfo.setType(setAnimalType(Integer.parseInt(scanner.nextLine())));
        return collecterInfo;
    }
}
