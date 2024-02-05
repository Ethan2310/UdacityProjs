package InheritanceExample;

public class Person {

    private String firstName, lastName;

    Person(){}


    Person(String fName, String lName){
        super();
        firstName = fName;
        lastName=lName;

    }

    public  void setfirstName(String fName){firstName= fName;}
    public  void setlastName(String lName){lastName= lName;}
    public  String getfirstName(){return firstName;}
    public  String getlastName(){return lastName;}

    public String toString(){

        return "FirstName: "+ firstName + " LastName: " + lastName;

    }
}
