package models;

public class FreeRoom extends Room{

    FreeRoom(String roomNumber, RoomType roomType)
    {
        this.roomNumber = roomNumber;
        this.price = 0.00;
        this.roomType = roomType;
    }
}
