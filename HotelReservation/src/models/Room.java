package models;

import java.text.NumberFormat;

public class Room implements IRoom{

    protected String roomNumber;
    protected Double price;
    public RoomType roomType;

    public Room(){}

    public Room(String roomNumber, Double price, RoomType roomType)
    {
        super();

        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;

    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    public void setPrice(Double d) {price=d;}
    public void setRoomNumber(String n){roomNumber=n;}

    @Override
    public Boolean isFree() {
        return price == 0.00;
    }

    public String toString(){

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

         return "The Room Number is: " + roomNumber + "\n" +
                 "The Room Price is: " + formatter.format(price) + "\n" +
                 "The Room Type is: " + roomType + "\n";

    }
}
