package InheritanceExample;

public class StudentEmployee extends Student{

    private double rateOfPayPerHour;
    String employeeID;

    StudentEmployee(String fName, String lName, String studID, String empID, double rate ){
        super(fName,lName,studID);
        rateOfPayPerHour = rate;
        employeeID=empID;
    }

    public String getEmployeeID(){return employeeID;}
    public double getRate(){return rateOfPayPerHour;}

    public void setEmployeeID(String empID){employeeID=empID;}
    public void setRateOfPayPerHour(double rate){rateOfPayPerHour=rate;}

    public String toString(){

        return "EmployeeID: " + employeeID + " RateOfPay: " + rateOfPayPerHour;

    }

}
