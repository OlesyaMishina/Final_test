package view;

import java.util.Scanner;
import presenter.Presenter;

/**
 * Console
 */
public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    public String filename = "listAnimals.dat";
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
                //     FindAnimalByType();
                //     break;
                // case 5:
                //     FindAnimalByName();
                //     break;
                // case 6:
                //     SetNewCommand();
                //     break;
                case 7:
                    saveRecordsInFile();
                    break;
                case 8:
                    exit();
                    // break;
                default:
                    System.out.println("Введите число!");
            }
        }
    }

    // 1 - Загрузить список животных питомника из файла\n"
    private void loadListFromFile() {
        System.out.printf("\nFile " + filename + " has been loaded:\n");
        System.out.print("id animal, type animal; name animal");
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

    // // 4 - Найти всех животных отдного типа\n"
    // private void raffleToy() {
    //     presenter.chooseRecord();
    // }

    // // 5 - Найти животное и распечатать список его команд\n
    // private void getAllPrizeToys() {
    //     presenter.getAllChooseRecords();
    // }

    // // 6 - Научить животное новой команде\n
    // private void giveOutToy() {
    //     presenter.deleteRecord();
    // }

    // 7 - Сохрянить список доступных игрушек в файл\n
    private void saveRecordsInFile() {
        System.out.printf("File " + filename + " has been written.\n");
        presenter.saveRecords();
    }

    // Сохранить список животных питомника в файл
    private void exit() {
        System.out.println("Работа программы завершена.");
        scanner.close();
        work = false;
    }
}


