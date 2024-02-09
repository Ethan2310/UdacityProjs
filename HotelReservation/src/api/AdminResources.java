package api;

import models.Customer;
import models.IRoom;
import models.Reservation;
import models.Room;
import services.CustomerService;
import services.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AdminResources {

    private static AdminResources reference = new AdminResources();
    private static CustomerService cServices;
    private static ReservationService rServices;

    public AdminResources(){

        cServices = new CustomerService();
        rServices = new ReservationService();
    }

    public Customer getCustomer(String email)
    {
        return cServices.getCustomer(email);
    }

    public Reservation bookARoom(String CustomerEmail, IRoom room, Date CheckIn, Date CheckOut)
    {
        Customer customer = getCustomer(CustomerEmail);
        return rServices.reserveARoom(customer,room,CheckIn,CheckOut);
    }

    public void addRoom(Room room){


            rServices.addRoom(room);


    }

    public Collection<IRoom> getAllRooms(){

        return rServices.availableRooms;
    }

    public Collection<Customer> getAllCustomers(){

        return cServices.getAllCustomers();
    }

    public void displayAllReservations(){

        rServices.printAllReservations();
    }
    public AdminResources getInstance(){

        return reference;
    }

    public static ReservationService getRServices() {
        return rServices;
    }

    public void addCustomer(String email, String firstName, String lastName) {
        cServices.addCustomer(email, firstName, lastName);
    }
}
