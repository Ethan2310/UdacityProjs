package PolymorpishmExample;

public class Vehicle {

    protected String start, stop, speed, direction;

    Vehicle(){}
    Vehicle(String fStart, String fStop, String fSpeed, String  fDir){
        super();
        start = fStart;
        stop = fStop;
        speed=fSpeed;
        direction=fDir;
    }

    public void start(){System.out.println(start);}
    public void stop(){System.out.println(stop);}
    public void speed(){System.out.println(speed);}
    public void direction(){System.out.println(direction);}


}
