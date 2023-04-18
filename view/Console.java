package view;

import java.io.IOException;
import java.util.Scanner;

import presenter.Presenter;

public class Console  implements View{
    private Scanner scanner;
    private Presenter presenter;



    public Console(){
        scanner = new Scanner(System.in);
    }

    private void printInvitationForUser(){
        System.out.println();
        String str = "Выберите операцию и введите соответствующую цифру:\n" +
                " 1 - для печати полного списка генеалогического древа с указанием детей\n" +
                " 2 - для записи и сохранения в файл списка родственников древа \n" +
                " 3 - для чтения и получения списка родственников из файла \n" +
                " 4 - для завершения работы \n";
    System.out.println(str);
    }
    @Override
    public void start() throws IOException, ClassNotFoundException {
        printInvitationForUser();
        while (isWorking) {
            int operationNumber = scanner.nextInt();
            switch (operationNumber) {
                case 0:
                    exit();
                    break;
                case 1:
                    presenter.printChildren();
                    printInvitationForUser();
                    break;
                case 2:
                    presenter.writeTreeInFile();
                    System.out.printf("Вы успешно сохранили список генеалогического древа в файл \"%s.%s\" !\n", presenter.getFileName(), presenter.getFileType());
                    printInvitationForUser();
                    break;
                case 3:
                    System.out.printf("Генеалогическое древо, прочитанное из файла \"%s.%s\":\n", presenter.getFileName(), presenter.getFileType());
                    presenter.readFromFile();
                    presenter.print();
                    printInvitationForUser();
                    break;
                
                case 4 :
                    presenter.getHumanByName();
                    printInvitationForUser();
                    break;
                default:
                    System.out.println("Вы ввели некорректный номер операции!");
                    printInvitationForUser();
            }
        }
    }

    private void exit() {
        System.out.println("Работа завершена, всего доброго!");
        scanner.close();
        isWorking = false;
    }




    @Override
    public void setPresenter(Presenter presenter) {
       this.presenter = presenter;
        
    }
    
}
