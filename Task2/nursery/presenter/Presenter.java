package presenter;

import model.Service;
import view.CollecterInfo;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void loadRecordsFromFile() {
        String answer = service.loadNurseryList();
        view.print(answer);
    }

    public void getAllRecords() {
        String answer = service.getNurseryList();
        view.print(answer);
    }

    public void addRecord(CollecterInfo collecterInfo) {
        service.addAnimal(collecterInfo);
    }

    // public void getAllChooseRecords() {
    //     String answer = service.getPrizeToysList();
    //     view.print(answer);
    // }

    // public void chooseRecord() {
    //     String answer = service.raffleToy();
    //     view.print(answer);
    // }

    public void saveRecords() {
        String answer = service.saveAnimalList();
        view.print(answer);
    }

    // public void deleteRecord() {
    //     service.deletePrizeToy();
    // }
}
