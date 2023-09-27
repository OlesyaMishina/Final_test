package Task2.project.view;
import Task2.project.presenter.Presenter;

/**
 * view
 */
public interface View {

    void print(String text);

    void start();

    void setPresenter(Presenter presenter);
}