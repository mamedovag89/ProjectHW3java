package presenter;

import java.io.IOException;

import javax.swing.text.View;

import model.Service;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    
}
public Human readAndCreateHuman() {
    return service.readAndCreateHuman();
}

public void getHumanByName() {
    service.getHumanByName();
}

public void print() {
    service.print();
}

public String getFileName() {
    return service.getFileName();
}

public String getFileType() {
    return service.getFileType();
}

public void createInitialTree() {
    service.createInitialTree();
}

public void printChildren() {
    service.printChildren();
}

public void writeTreeInFile() throws IOException {
    service.writeTreeInFile();
}


public void addHuman(Human human) {
    service.addHuman(human);
    System.out.printf("Вы успешно добавили добавили в древо нового родственника:\n  %s\n", human.toString());
}
}

