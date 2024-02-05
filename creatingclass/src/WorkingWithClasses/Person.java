package WorkingWithClasses;

public class Person {

    private String firstName, lastName;

    Person(String fName, String lName)
    {
        firstName=fName;
        lastName=lName;

    }

    public void setFirstName(String fName){firstName=fName;}
    public void setLastName(String lName){lastName=lName;}

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}

    public String toString(){

        return "First Name: "+firstName+ " LastName: " +lastName;

    }


}
