package services;

import models.Customer;
import models.IRoom;
import models.Reservation;

import java.util.*;

public class ReservationService {

    private static ReservationService reference = new ReservationService();
    private Queue<Reservation> reservations;
    public Set<IRoom> availableRooms;
    public ReservationService(){
        reservations = new LinkedList<Reservation>();
        availableRooms = new HashSet<IRoom>();
    }

    public void addRoom(IRoom room)
    {

        //System.out.println("HI");
        availableRooms.add(room);
       // System.out.println(availableRooms.toString());
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkIn, Date checkOut)
    {

        Reservation res = new Reservation(customer,room,checkIn,checkOut);
        reservations.add(res);
        return res;

    }

    public Collection<IRoom> findRooms(Date checkIn, Date checkOut)
    {
        Set<IRoom> foundRooms = new HashSet<>();

        for(Reservation r : reservations)
        {
            if(r.getCheckIn()==checkIn && r.getCheckOut()==checkOut)
            {
                foundRooms.add(r.getRoom());
            }
        }

        return foundRooms;
    }

    public IRoom getRoom(String roomID)
    {
       // System.out.println("HI");
        for(IRoom r : availableRooms)
        {

            if(r.getRoomNumber().equals(roomID))
            {
                return r;
            }
        }
        System.out.println("ROOM NOT FOUND");
    return null;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer)
    {
        Set<Reservation> customerReservations = new LinkedHashSet<>();
        for(Reservation r : reservations)
        {
            if(r.getCustomer()==customer)
            {
                customerReservations.add(r);
            }
        }
        return customerReservations;

    }

    public void printAllReservations(){

        for(Reservation r : reservations)
        {
            System.out.println(r.toString());
        }
    }

    public ReservationService getInstance(){

        return reference;
    }



}
