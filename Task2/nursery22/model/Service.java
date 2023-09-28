package Task2.project.model;

import Task2.project.view.CollecterInfo;

public class Service {
    private AnimalType type;
    private Nursery listAnimals;
    private FileHandler fileHandler;
    private Counter count;
    private String filename = "listAnimals.dat"; // файл для хранения списка животных в питомнике

    public Service(Nursery listAnimals) {
        this.listAnimals = listAnimals;
        fileHandler = new FileHandler();
        count = new Counter();
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
        listAnimals.addAnimal(animal);
    }

    // public String getPrizeToysList() {
    // System.out.println("Cписок призовых игрушек:");
    // if (listPrizeToys.getPrizeToysList().isEmpty())
    // return "пуст. Запустите розыгрыш призовой игрушки.";
    // else
    // return listPrizeToys.getPrizeToysList().toString();
    // }

    // public String saveToysList() {
    // fileHandler.SaveToFile(listToys, filename);
    // return listToys.getToysList().toString();
    // }

    // Розыгрыш призовой игрушки. Работа со списком достуаных игрушей. Если
    // количество меньше 1, удаляем ее, если боличнство
    // больше 1, уменьшаем количество. Разыгранную игрушку добавляем в список
    // призовых игрушек.

    // Удаление призовой игрушки, уладенная игрушка Дозаписывается в файл
    // "listGiveOutToys.dat"
    public void deletePrizeToy() {
        Toy giveOutToy = listPrizeToys.poll();
        if (giveOutToy == null)
            System.out.println("Список призовых игрушек пуст. Запустите розыгрыш призовых игрушек.");
        else {
            System.out.println("Выдана игрушка: " + giveOutToy);
            fileHandler.SaveToFileGiveOutToys(giveOutToy, fileGiveOut);
        }
    }
}
