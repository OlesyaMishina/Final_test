package model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.css.Counter;

import view.CollecterInfo;

public class Service {
    private List<Commands> commands;;
    private Nursery listAnimals;
    private FileHandler fileHandler;
    private String filename = "listAnimals.txt"; // файл для хранения списка животных в питомнике

    public Service(Nursery listAnimals) {
        this.listAnimals = listAnimals;
        fileHandler = new FileHandler();
        // count = new Counter();
    }

    public String loadNurseryList() {
        listAnimals = fileHandler.loadFromFile(filename);
        return listAnimals.getAnimalList().toString();
    }

    public String getNurseryList() {
        System.out.println("Cписок животных питомника:\n");
        if (listAnimals.getAnimalList().isEmpty())
            return "пуст. Загрузите список из файла или добавьте животное вручную.";
        else
            return listAnimals.getAnimalList().toString();
    }

    public void addAnimal(CollecterInfo collecterInfo) {
        RestoreAnimalFromConsole rAnimal = new RestoreAnimalFromConsole();
        Animal animal = rAnimal.restoreAnimalFromConsole(listAnimals, collecterInfo);
        // System.out.println(animal);
        listAnimals.addAnimal(animal);
    }

    public String saveAnimalList() {
        fileHandler.saveToFile(listAnimals, filename);
        return listAnimals.getAnimalList().toString();
    }

    public String findAnimalByName(String name) {
        List<Commands> commands;
        commands = listAnimals.getAnimalByName(name).getCommands();
        StringBuilder sb = new StringBuilder();
        if (commands.size() == 0)
            System.out.println("Список команд пуст.");
        else {
            sb.append("Список команд:" + name);
            for (int i = 0; i < commands.size(); i++) {
                sb = sb.append(" ").append(commands.get(i)).append(", ");
            }
        }
        return sb.toString();
    }

    public String addCommand(String name, int command) {
        commands = listAnimals.getAnimalByName(name).getCommands();
        switch (command) {
            case 1:
                if (commands.contains(Commands.GO))
                    System.out.println("Такая команда уже есть.");
                else
                    commands.add(Commands.GO);
                break;
            case 2:
                if (commands.contains(Commands.JUMP))
                    System.out.println("Такая команда уже есть.");
                else
                    commands.add(Commands.JUMP);
                break;
            case 3:
                if (commands.contains(Commands.SIT))
                    System.out.println("Такая команда уже есть.");
                else
                    commands.add(Commands.SIT);
                break;
            case 4:
                if (commands.contains(Commands.PLAY))
                    System.out.println("Такая команда уже есть.");
                else
                    commands.add(Commands.PLAY);
                break;
            case 5:
                if (commands.contains(Commands.SLEEP))
                    System.out.println("Такая команда уже есть.");
                else
                    commands.add(Commands.SLEEP);
                break;
            case 6:
                if (commands.contains(Commands.VOICE))
                    System.out.println("Такая команда уже есть.");
                else
                    commands.add(Commands.VOICE);
                break;
            default:
                System.out.println("Введите число!");
        }
        return commands.toString();

    }
}
