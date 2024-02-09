package models;

import java.util.Date;

public class Reservation {

    private Customer customer;
    private IRoom room;
    private Date checkIn, checkOut;

   public Reservation(Customer customer, IRoom room, Date checkIn, Date checkOut)
    {
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    public void setCustomer(Customer c) { customer=c;}
    public void setRoom(IRoom r) {room=r;}
    public void setCheckIn(Date dIn){checkIn=dIn;}
    public void setCheckOut(Date dOut){checkOut=dOut;}

    public Customer getCustomer() {
        return customer;
    }

    public Date getCheckIn() {
            return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public IRoom getRoom() {
        return room;
    }

    public String toString(){

        return "Reservation Details: " + "\n"+
                "~Customer: " + customer + "\n"+
                "~Room: " + room + "\n"+
                "~Check-In Date: " + checkIn + "\n"+
                "~Check-Out Date: " + checkOut + "\n";

    }
}
