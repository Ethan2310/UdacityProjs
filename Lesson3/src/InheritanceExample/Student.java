package InheritanceExample;

public class Student extends Person{

    private String studentID;

    Student(){}

    Student(String fName, String lName, String studID){
        super(fName,lName);
        studentID=studID;

    }

    public void setStudentID(String studID){studentID=studID;}
    public String getStudentID(){return studentID;}

    public String toString(){

        return super.toString() + " StudentID: " + studentID;
    }
}
