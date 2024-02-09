package Menus;

import api.AdminResources;
import api.HotelResources;
import models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.StreamSupport;

public class MainMenu {

    private static final AdminResources adminResource = new AdminResources();
    private static final HotelResources hotelResources = new HotelResources();
    public static Scanner input;
    private static List<IRoom> rooms = new ArrayList<>();

    private static RoomType rType;

    public static void main(String args[]) throws FileNotFoundException {
        input = new Scanner(System.in);
        int state =1;
        int exitState =6;
        readRooms();
        readCustomers();




        while(state!=exitState)
        {
            state = ShowMenu();

            switch (state)
            {
                case 1:
                    System.out.println("Here is a list of all available rooms:");
                    showRooms();
                    System.out.println("Enter Room Number of desired room:");
                    Scanner s = new Scanner(System.in);
                    String roomNum = s.next();
                    System.out.println("Enter your email");


                    String email = s.next();

                    boolean found = false;

                    for(Customer c : adminResource.getAllCustomers())
                    {
                        //System.out.println(c.getEmail());
                        if(c.getEmail().equals(email)) found =true;
                    }

                    if(found==true)
                    findAndReserveRoom(roomNum,email);
                    else {

                        System.out.println("USER DOES NOT EXIST, PLEASE SELECT OPTION 3");
                        ShowMenu();
                    }




                case 2:

                    seeReservation();



                case 3:
                    System.out.println("WELCOME NEW USER");
                    System.out.println("PLEASE ENTER DETAILS BELOW");
                    createCustomer();




                case 4:
                    goToAdmin();



                case 5:
                    input.close();
                    System.exit(0);

                default:
                    main(null);
                    break;

            }

        }


    }

    public static int ShowMenu()
    {
        String initalMenu="";
        initalMenu= "(1) Find and reserve a room. \n";
        initalMenu = initalMenu + "(2) See my reservations. \n";
        initalMenu = initalMenu+ "(3) Create an account. \n";
        initalMenu = initalMenu+ "(4) Admin. \n";
        initalMenu = initalMenu+ "(5) Exit Application. \n";

        System.out.println(initalMenu);
        System.out.println("==============");
        System.out.println("Enter menu:");

        return input.nextInt();

    }

    public static void readRooms() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("Rooms.txt"));
        String RoomNumber="";
        Double RoomPrice =0.00;
        String RoomType="";




        while(scanner.hasNextLine())
        {

            RoomNumber = scanner.next();
            RoomPrice = Double.valueOf(scanner.next());
            rType = models.RoomType.valueOf(scanner.next());
            rooms.add(new Room(RoomNumber,RoomPrice,rType));
            adminResource.addRoom(new Room(RoomNumber,RoomPrice,rType));
            hotelResources.addRoom(new Room(RoomNumber,RoomPrice,rType));
            if(scanner.hasNextLine())scanner.nextLine();
        }
    }

    public static void showRooms(){

        for(IRoom r : rooms)
        {
            System.out.println(r);

        }


    }
    public static void findAndReserveRoom(String roomNum, String email) throws FileNotFoundException {

        Date today = new Date();
        today = today;
        System.out.println("Details of room:");
        System.out.println(hotelResources.getRoom(roomNum).toString());
        hotelResources.bookARoom(email, hotelResources.getRoom(roomNum), today, today);
        adminResource.bookARoom(email,hotelResources.getRoom(roomNum), today, today);
        System.out.println(hotelResources.getRoom(roomNum).getRoomNumber() + " has been booked");
        main(null);



    }

    public static void createCustomer() throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String fName = scanner.next();

        System.out.println("Enter Last Name:");
        String lName = scanner.next();

        System.out.println("Enter Email in form ---@---.com");
        String email = scanner.next();

        try {
            adminResource.addCustomer(email, fName, lName);
        }
        catch (IllegalArgumentException ex){System.out.println("INVALID EMAIL");
        }
        finally {
            main(null);
        }

    }

    public static void readCustomers() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("Customers.txt"));

        String fName="";
        String lName ="";
        String email="";

        while(scanner.hasNextLine())
        {

            fName = scanner.next();
            lName = scanner.next();
            email = scanner.next();

            adminResource.addCustomer(email,fName,lName);
            if(scanner.hasNextLine())scanner.nextLine();
        }

    }

    public static void seeReservation() throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email to view your reservations:");
        String email = scanner.next();


        Collection<Reservation> customerReservations = hotelResources.getCustomersReservations(email);

        for(Reservation r : customerReservations)
        {
            System.out.println(r.toString());
        }

        main(null);
    }

    public static void goToAdmin() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER ADMIN PASSWORD:");
        String password = scanner.next();

        if(password.equals("admin"))
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            AdminMenu.setAdminResources(adminResource);
            AdminMenu.setHotelResources(hotelResources);

            AdminMenu.startAdmin();

        }
        else{

            System.out.println("INCORRECT PASSWORD");
            main(null);
        }


    }

}
