
import api.AdminResources;
import models.IRoom;
import models.Room;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainMenu extends AdminResources{

    private String initalMenu="";

    MainMenu(){
        super();


        initalMenu= "(1) Find and reserve a room. \n";
        initalMenu = initalMenu + "(2) See my reservations. \n";
        initalMenu = initalMenu+ "(3) Create an account. \n";
        initalMenu = initalMenu+ "(4) Admin. \n";
        initalMenu = initalMenu+ "(5) Exit Application. \n";
    }

    public void refreshMenu(){
        System.out.println(initalMenu);
    }

    public void inputRooms() throws  IOException{

        Scanner scanner = new Scanner(new File("Rooms.txt"));
        String RoomNumber="";
        Double RoomPrice =0.00;
        String RoomType="";
        int count =0;
        List<IRoom> rooms = new ArrayList<>();

        while(scanner.hasNextLine())
        {
            while(scanner.hasNext()){
            switch (count){

                case 0:
                    RoomNumber=scanner.next();

                case 1:
                    RoomPrice = Double.valueOf(scanner.next());

                case 2:
                    RoomType= scanner.next();
            }
               count++;

            getRServices().addRoom(new Room());



            } // end of inner while
            scanner.nextLine();


        }
    }

    public void displayRooms(){

            Path path = Paths.get("Rooms.txt");
                try {
                    List<String> lines = Files.readAllLines(path);
                    for(String line : lines){

                        System.out.println(line);
                    }
                } catch (IOException ex) {
                    // handle exception...
                    System.out.println("File Not Found");
                }





    }

    public String option1(){

        return "Here are all the available rooms:";

    }
}
