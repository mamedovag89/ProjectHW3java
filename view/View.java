package view;

import java.io.IOException;

import presenter.Presenter;

public interface View {
    void print(String text);
    void start() throws IOException, ClassNotFoundException;;
    void setPresenter(Presenter presenter);
}
