import java.io.Console;
import java.io.IOException;
import java.security.Provider.Service;
import java.util.logging.FileHandler;

import javax.swing.text.View;

import presenter.Presenter;

public class MainMVP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler("familyTree", "out");
        FamilyTree<model.Human> familyTree = new FamilyTree<>();
        
        Service service = new Service(familyTree, fileHandler);
        View view = new Console();
        
        Presenter presenter = new Presenter(view, service);
        presenter.createInitialTree();
        
        view.start();
    }
    
}
