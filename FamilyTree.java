import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FamilyTree
 */
public class FamilyTree<H extends Human> implements Serializable, FamilyTreeIterator<H> {

    private List<Human> familyTree;
    private int id;

    public int getLastId(){
        return this.familyTree.size() - 1;
    }


    public  FamilyTree(){
        this.familyTree = new ArrayList<Human>();
    }
    public void createInitialFamilyTree() {
        Human h_1 = new Human(this.id++, "Иванов Иван Иванович", Gender.male, 1990);;
        Human h_2 = new Human(this.id++, "Иванова Мария Ивановна", Gender.female, 1991);
        Human h_3 = new Human(this.id++, "Петрова Елена Владимировна", Gender.female,h_1, h_2, 2013);
        Human h_4 = new Human(this.id++, "Иванов Петр Иванович", Gender.male, h_1, h_2,  2023 );
        Human h_5 = new Human(this.id++, "Петров Вадим Сергеевич",Gender.male, 1989);
        Human h_6 = new Human(this.id++, "Морозова Марина Андреевна",Gender.male,h_5, h_3,  2023 );
        Human h_7 = new Human(this.id++, "Морозов Мартин Андреевич", Gender.male,h_5,h_3,  2022 );
        List<Human> humans = new ArrayList<>(Arrays.asList(h_1, h_2, h_3, h_4, h_5, h_6, h_7));
    
        FamilyTree familyTree_1 = new FamilyTree();
        for (Human human : humans) {
            familyTree_1.addHuman(human);
        }
        this.familyTree = familyTree_1.getFamilyTree();
    }
    
    
    
        public void addHuman(Human human){
        this.familyTree.add(human);
        if (human.getMother() != null){
            human.getMother().addChild(human);

        }
        if(human.getFather() != null){
            human.getFather().addChild(human);
        }
    }


    public void getInfoAboutFamilyTree() {
        System.out.println("Список родственников древа состоит из:");
        for (Human human: familyTree) {
            System.out.println(human);
        }
    }

    public Gender getGender(String g) {
        if (g.equals("м")){
            return Gender.male;
        }
        return Gender.female;
    }
    public H getHumanById(int id){
        for (H human: this.familyTree) {
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public void printChildren() {
        System.out.println("Список генеалогического древа с указанием наличия (отсутствия) детей:");
        int index = 1;
        for (H humanTemp : familyTree) {
            if (humanTemp.getChildren().isEmpty()) {
                System.out.printf("%d)%s (%d) не имеет детей!\n ", index++, humanTemp.getFullName(), humanTemp.getBirthYear());
                System.out.println();
            } else {
                System.out.printf("%d)%s (%d) имеет следующих детей:\n %s\n", index++, humanTemp.getFullName(), humanTemp.getBirthYear(), humanTemp.getChildren());
                System.out.println();
            }
        }
    }

    public void sortByName() {
        this.familyTree.sort(new HumanName());
    }

    public void sortByBirthday() {
        this.familyTree.sort(new HumanBirthday());
    }

    public void sortById() {        this.familyTree.sort(new HumanId());    }

    public List<H> getFamilyTree() {
        return familyTree;
    }

    @Override
    public boolean hasNext() {
        return this.id < familyTree.size();
    }

    @Override
    public H next() {
        return this.familyTree.get(id++);
    }
}
    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("Генеалогическое древо состоит из: \n");
        for (Human human : familyTree) {
            stb.append(human).append("\n");
        }
        return stb.toString();
    }
    public void printChildren() {
        for (Human humanTemp : familyTree) {
            if (humanTemp.getChildren().isEmpty()) {
                System.out.printf("%s (%d) не имеет детей!\n ", humanTemp.getFullName(), humanTemp.getBirthYear());
            } else {
                System.out.printf("%s (%d) имеет следующих детей:\n %s\n", humanTemp.getFullName(), humanTemp.getBirthYear(), humanTemp.getChildren());
            }
        }
    
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(" В дереве ");
        sb.append(familyTree.size());
        sb.append("Объектов: \n");
        for (Human human: familyTree) {
            sb.append(human.getInfo());
            sb.append(("\n"));

        }
        return sb.toString();
    } 
