
import model.Nursery;
import model.Service;
import presenter.Presenter;
import view.Console;
import view.View;

public class main {
    public String filename = "listAnimals.dat";

    public static void main(String[] args) {
        Nursery listAnimals = new Nursery();
        View view = new Console();
        Service service = new Service(listAnimals);
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
