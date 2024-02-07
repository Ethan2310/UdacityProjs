package mapsExample;

public class person {

    private String name,email;

    person(String fName, String fEmail){

        super();
        name = fName;
        email = fEmail;
    }

    public void setName(String fName){
        name = fName;
    }
    public void setEmail(String fEmail){
        email=fEmail;
    }
    public String getName(){return name;}
    public String getEmail(){return email;}

    public String toString(){

        return "Name: " + name+ "Email: " + email;
    }
}
