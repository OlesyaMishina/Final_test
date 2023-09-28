package Task2.nursery;

import javax.swing.text.View;

import Task2.project.model.Nursery;
import Task2.project.presenter.Presenter;
import model.Service;

public class Main {
    public String filename = "listAnimals.dat";

    public static void main(String[] args) {
        Nursery listAnimals = new Nursery();
        View view = new Console();
        Service service = new Service(listAnimals);
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}


