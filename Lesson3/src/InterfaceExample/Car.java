package InterfaceExample;

public class Car implements Vehicle {

    private String type, speed, color;

    Car(String fType, String fSpeed, String fColor){
        type = fType;
        speed=fSpeed;
        color=fColor;

    }

    public String getType(){ return type;}
    public String getSpeed(){ return speed;}
    public String getColor(){ return color;}
}
