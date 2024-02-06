package exceptionClass;

public class Phone {

    private String phoneType, phoneNumber;

    Phone(String fType, String fNum){

        super();

        if (phoneType == null || phoneNumber == null) {
            throw new IllegalArgumentException("The type or number cannot be null");
        }

        phoneType=fType;
        phoneNumber=fNum;
    }

    public void setPhoneType(String fType){ phoneType=fType;}
    public void setPhoneNumber(String fNum){phoneNumber=fNum;}
    public String getPhoneType(){return phoneType;}
    public String getPhoneNumber(){return phoneNumber;}

    public String toString(){

        return "Phone Type: " + phoneType + " Phone Number: " + phoneNumber;

    }


}
