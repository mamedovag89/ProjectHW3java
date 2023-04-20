package model;
import java.io.*;
import java.io.IOException;
import java.util.logging.FileHandler;

/**
 * Service
 */
public class Service {
    private FamilyTree<Human> familyTree;
    private FileHandler handler;
    private CreateNewHuman createNewHuman;
    private FindHuman findHuman;


    public Service(FamilyTree<Human> familyTree, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
        this.createNewHuman = new CreateNewHuman(familyTree);
        this.findHuman = new FindHuman(familyTree);
    }

    private void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public String getFileName() {
        return fileHandler.getFileName();
    }

    public String getFileType() {
        return fileHandler.getFileType();
    }

    public Human readAndCreateHuman() {
        return createNewHuman.readAndCreateHuman();
    }

    public void getHumanByName(){
        findHuman.getHumanByName();
    }

   public void addHuman(Human human) {
        familyTree.addHuman(human);
    }

    public void writeTreeInFile() throws IOException {
        fileHandler.writeTreeInFile(familyTree);
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        setFamilyTree(fileHandler.readFromFile());
    }

    public void sortByParameter(int sortNumber){
        familyTree.sortByParameter(sortNumber);
    }

    public void printChildren() {
        System.out.println("Список генеалогического древа с указанием наличия (отсутствия) детей:");
        int index = 1;
        for (Human humanTemp : familyTree.getFamilyTree()) {
            if (humanTemp.getChildren().isEmpty()) {
                System.out.printf("%d)id : %d;  %s (%d) не имеет детей!\n ", index++, humanTemp.getId(), humanTemp.getFullName(), humanTemp.getBirthYear());
                System.out.println();
            } else {
                System.out.printf("%d)id : %d;  %s (%d) имеет следующих детей:\n   %s\n", index++, humanTemp.getId(),humanTemp.getFullName(), humanTemp.getBirthYear(), humanTemp.getChildren());
                System.out.println();
            }
        }
    }

    public void print() {
        System.out.println("Список родственников древа состоит из:");

        while (familyTree.hasNext()) {
            System.out.println(familyTree.next().toString());
        }
    }

    public void createInitialTree() {
        int id = 0;
        Human h_1 = new Human(id++, "Иванов Иван Иванович", Gender.male, 1990);
        Human h_2 = new Human(id++, "Иванова Мария Ивановна", Gender.female, 1991);
        Human h_3 = new Human(id++, "Петрова Елена Владимировна", Gender.female, h_1, h_2, 1992);
        Human h_4 = new Human(id++, "Иванов Петр Иванович", Gender.male, h_1, h_2, 2023);
        Human h_5 = new Human(id++, ""Петров Вадим Сергеевич",Gender.male, 1989);
        Human h_6 = new Human(id++, "Морозова Марина Андреевна",Gender.male, h_5, h_3, 2023);
        Human h_7 = new Human(id++, "Петров  Александ Вадимович",Gender.male,h_5, h_3, 2013);
        Human h_8 = new Human(id, "Морозов Мартин Андреевич", Gender.male,  h_1, h_2, 2022);
        List<Human> humans = new ArrayList<>(Arrays.asList(h_1, h_2, h_3, h_4, h_5, h_6, h_7, h_8 ));

        for (Human human : humans) {
            familyTree.getFamilyTree().add(human);
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
        }
    }
}
    