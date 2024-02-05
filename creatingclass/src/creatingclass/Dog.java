package creatingclass;

public class Dog {
    private String dogType;
    private String dogName;
    private String dogColor;
    private int dogAge;

    Dog(String type, String name, String color, int age)
    {
        dogType = type;
        dogName=name;
        dogColor=color;
        dogAge=age;
    }

    public void setDogType(String type){ dogType=type;}
    public void setDogName(String name){ dogName=name;}
    public void setDogColor(String color){ dogColor=color;}
    public void setDogAge(int age){ dogAge = age;}

    public String getDogType(){return dogType;}
    public String getDogName(){return dogName;}
    public String getDogColor(){return dogColor;}

    public int getDogAge(){return dogAge;}

    public String toString(){

    return "DogType:" +dogType + "DogName:" +dogName + "DogColor:" +dogColor + "DogAge:" +dogAge;


    }

}
