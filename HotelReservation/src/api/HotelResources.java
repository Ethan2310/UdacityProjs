package api;

import models.Customer;
import models.IRoom;
import models.Reservation;
import models.Room;
import services.CustomerService;
import services.ReservationService;

import java.security.Provider;
import java.util.Collection;
import java.util.Date;

public class HotelResources{

    private static HotelResources reference = new HotelResources();
    private static CustomerService cServices= new CustomerService();;
    private static ReservationService rServices= new ReservationService();



    public Customer getCustomer(String email){

       return cServices.getCustomer(email);

    }

    public void CreateACustomer(String email, String fName, String lName)
    {
        cServices.addCustomer(email,fName,lName);
    }

    public void addRoom(Room r)
    {
        rServices.addRoom(r);
    }

    public IRoom getRoom(String RoomNum)
    {
        return rServices.getRoom(RoomNum);
    }

    public Reservation bookARoom(String CustomerEmail, IRoom room, Date CheckIn, Date CheckOut)
    {
        Customer customer = getCustomer(CustomerEmail);
        return rServices.reserveARoom(customer,room,CheckIn,CheckOut);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail)
    {
        Customer customer = getCustomer(customerEmail);
        return rServices.getCustomerReservation(customer);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut)
    {
        return rServices.findRooms(checkIn,checkOut);
    }



    public HotelResources getInstance(){
        return reference;
    }

}
