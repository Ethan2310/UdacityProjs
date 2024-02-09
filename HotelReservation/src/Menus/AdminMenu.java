package Menus;

import api.AdminResources;
import api.HotelResources;
import models.IRoom;
import models.Room;
import models.RoomType;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private static AdminResources adminResources;

    private static HotelResources hotelResources;

    private static Scanner input;
    static int mainMenu = 5;
    private static int selection=0;

    private static  MainMenu mMenu;


    public static void startAdmin() throws FileNotFoundException {


        input= new Scanner(System.in);

        while (selection!=mainMenu)
        {
            selection = showMenu();
            switch (selection)
            {
                case 1:

                    System.out.println(adminResources.getAllCustomers());
                    break;

                case 2:
                    System.out.println(adminResources.getAllRooms());
                    break;

                case 3:
                    adminResources.displayAllReservations();
                    break;

                case 4:
                    addRoom();

                case 5:
                    MainMenu.main(null);

            }


        }


    }

    public static void setAdminResources(AdminResources a)
    {
        adminResources=a;
    }

    public static void setHotelResources(HotelResources h)
    {
        hotelResources = h;
    }



    public static int showMenu(){

        String menu="";
        menu = menu + "(1) See All Customers \n";
        menu = menu + "(2) See All Rooms \n";
        menu = menu + "(3) See All Reservation \n";
        menu = menu + "(4) Add A Room \n";
        menu = menu + "(5) Back To Main Menu \n";

        System.out.println(menu);

        return input.nextInt();

    }

    public static void addRoom() throws FileNotFoundException {

        Room room = new Room();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room number:");
        room.setRoomNumber(scanner.next());

        System.out.println("Enter room price:");
        room.setPrice(scanner.nextDouble());

        System.out.println("Choose Room Type: \n 1 ~ SINGLE \n 2~ DOUBLE");
        int type = scanner.nextInt();


        if(type==1) {room.roomType = RoomType.SINGLE;} else {
            room.roomType = RoomType.DOUBLE;
        }

        adminResources.addRoom(room);
        startAdmin();
    }


}
