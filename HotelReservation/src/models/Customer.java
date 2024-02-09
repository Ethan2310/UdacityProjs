package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

    private String firstName, lastName, email;

    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email)
    {



            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            validateEmail(email);


    }

    public void setFirstName( String firstName) { this.firstName = firstName;}
    public void setLastName( String lastName) { this.lastName = lastName;}
    public void setEmail( String email) { this.email = email;}

    public String getFirstName(){return firstName;}
    public String getLastName(){ return lastName;}
    public String getEmail(){return email;}

    public void validateEmail(String email){

       // System.out.println(email);
        Matcher matcher = pattern.matcher(email);
       // System.out.println(matcher.matches());

        if(!matcher.matches()) throw new IllegalArgumentException("Invalid Email");
    }

    public String toString(){

        return "Details of Customer: " + "\n" +
                "-First Name: " + firstName + "\n"+
                "-Last Name: " + lastName + "\n"+
                "-Email: " + email + "\n";
    }
}
