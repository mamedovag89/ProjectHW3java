import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static void printInvitationForUser() {
        String str = "Выберите операцию и введите соответствующую цифру:\n" + " 1 - для создания списка родственников генеалогического древа \n" +
                " 2 - для записи и сохранения списка родственников \n" +
                " 3 - для чтения и получения списка родственников из файла \n" +
                " 0 - для выхода из меню \n";
        System.out.println(str);

    }



    private static FamilyTree cFamilyTree () {
        Human h1 = new Human ("Иванов Иван Иванович", Gender.male, 1990);
        Human h2 = new Human ("Иванова Мария Ивановна", Gender.female, 1991);
        Human h3 = new Human ("Петрова Елена Владимировна", Gender.female,1992);
        Human h4 = new Human ("Иванов Петр Иванович", Gender.male, 2023 );
        Human h5 = new Human ("Петров Вадим Сергеевич",Gender.male, 1989);
        Human h6 = new Human ("Морозова Марина Андреевна",Gender.male, 2023 );
        Human h7 = new Human ("Петров  Александ Вадимович",Gender.male, 2013 );
        Human h8 = new Human ("Морозов Мартин Андреевич", Gender.male, 2022 );
        ArrayList<Human> humans = new ArrayList<Human>(Arrays.asList(h1,h2,h3,h4,h5,h6,h7,h8));
    

        FamilyTree familyTree = new FamilyTree(); 
        for (Human human : humans) {
            familyTree.addHuman(human);

        }
        return familyTree;

      
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileHandler fh = new FileHandler();
        FamilyTree familyTree = new FamilyTree();
        printInvitationForUser();
        Scanner scn = new Scanner(System.in);
        try {
            while (scn.hasNextInt()) {
                int operationNumber = scn.nextInt();
                switch (operationNumber) {
                    case 1:
                        familyTree = cFamilyTree();
                        break;
                    case 2:
                        if (familyTree != null) {
                            fh.writeFile("familyTree", "txt", familyTree);
                            System.out.println("Вы успешно сохранили список генеалогического древа!");
                            System.out.println(familyTree);
                        }
                        break;
                    case 3:
                        familyTree = fh.readFile("familyTree", "out");
                        System.out.println(familyTree);
                        familyTree.printChildren();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Вы ввели некорректный номер операции!");
                }
                if (operationNumber == 0){
                    System.out.println("Всего доброго!");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

}
}
