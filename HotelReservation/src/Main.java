import models.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.refreshMenu();

        Scanner userInput = new Scanner(System.in);
        int input = userInput.nextInt();

        boolean ran = false;

        switch(input) {
            case 1:

                System.out.println(mainMenu.option1());
                mainMenu.displayRooms();
                ran = true;

            case 2:



            case 3:




            case 4:



            case 5:


        }

        if(!ran){
            System.out.println("INVALID");
            main(null);
        }

    }

}