package services;

import models.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

     private Map<String, Customer> mapOfCustomers;

     private static CustomerService reference = new CustomerService();

    public CustomerService(){
        mapOfCustomers = new HashMap<>();
    }

    public void addCustomer(String email, String firstName, String lastName){

        mapOfCustomers.put(email, new Customer(firstName,lastName,email));
        //System.out.println("USER " + firstName + " ADDED");

    }

    public void addCustomer(Customer c)
    {
        mapOfCustomers.put(c.getEmail(),c);

    }

    public Customer getCustomer(String email)
    {
        return mapOfCustomers.get(email);
    }

    public Collection<Customer> getAllCustomers(){
        return new ArrayList<Customer>(mapOfCustomers.values());
    }

    public CustomerService getInstance(){
        return reference;
    }
}
