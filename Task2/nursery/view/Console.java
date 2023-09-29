package view;

import java.util.Scanner;
import presenter.Presenter;

/**
 * Console
 */
public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    public String filename = "listAnimals.txt";
    private boolean work = true;

    public Console() {
        scanner = new Scanner(System.in, "cp866");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (work) {
            ToChooseStart start = new ToChooseStart();
            int choice = start.toChoose();
            switch (choice) {
                case 1:
                    loadListFromFile();
                    break;
                case 2:
                    getAllList();
                    break;
                case 3:
                    addRecord();
                    break;
                case 4:
                    findRecord();
                    break;
                case 5:
                    teachRecord();
                    break;
                case 6:
                    saveRecordsInFile();
                    break;
                case 7:
                    exit();
                default:
                    System.out.println("Введите число!");
            }
        }
    }

    // 1 - Загрузить список животных питомника из файла\n"
    private void loadListFromFile() {
        System.out.printf("\nFile " + filename + " has been loaded:\n");
        presenter.loadRecordsFromFile();
    }

    // 2 - Распечатать список животных питомника\n
    private void getAllList() {
        presenter.getAllRecords();
    }

    // 3 - Добавить новое животное в список животных питомника\n"
    private void addRecord() {
        CollecterInfo collecterInfo = new CollecterInfo();
        collecterInfo = collecterInfo.getInfoFromUser();
        presenter.addRecord(collecterInfo);
        System.out.printf("Животное " + collecterInfo.getName() + " добавлено.");
    }

    // 4 - Найти животное и распечатать список его команд\n
    private void findRecord() {
        System.out.println("Введите имя животного, команды которого вы хотите увидеть:");
        String name = scanner.nextLine();
        presenter.finfRecordByName(name);
    }

    // 5 - Научить животное новой команде\n
    private void teachRecord() {
        System.out.println("Введите имя животного, которого вы хотите научить новой команде:");
        String name = scanner.nextLine();
        System.out.println("Выберете команду, которой вы хотите научить животное:\n" 
        +"1 - GO, 2 - JUMP, 3 - SIT, 4 - PLAY, 5 - SLEEP, 6 - VOICE "        );
        int command = Integer.parseInt(scanner.nextLine());
        presenter.teachRecord(name, command);
    }

    //6 Сохранить список животных питомника в файл
    private void saveRecordsInFile() {
        System.out.printf("File " + filename + " has been written.\n");
        presenter.saveRecords();
    }

    // 7
    private void exit() {
        System.out.println("Работа программы завершена.");
        scanner.close();
        work = false;
    }
}


