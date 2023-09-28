package veiw;

import presenter.Presenter;

public interface Veiw {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
}
