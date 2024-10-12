/*
 * Problem1.java
 * This program demonstrates basic object-oriented programming (OOP) concepts in Java, including:
 * - Encapsulation: Using private fields with public getters and setters.
 * - Inheritance: The Employee class extends the Person class.
 * - Method Overriding: The introduce() method is overridden in the Employee class.
 *
 * Classes:
 * 1. Person: Represents a person with attributes for name, age, and occupation.
 * 2. Employee: Inherits from Person and adds an employeeID attribute.
 *
 * Main Functionality:
 * - Creates an instance of Employee and calls the introduce() method to display information.
 */
class Person {
    private String name; 
    private int age; 
    private String occupation; 
    public Person(String n, int a, String o){
        this.name = n; 
        this.age = a; 
        this.occupation = o; 
    }
    public void SetName(String s){
        this.name = s;
    }
    public void SetAge(int a){
        this.age = a; 
    }
    public void SetOccupation(String a){
        this.occupation = a; 
    }    
    public String GetName(){
        return this.name; 
    }
    public int GetAge(){
        return this.age; 
    }
    public String GetOccupation(){
        return this.occupation; 
    }    
    public void introduce(){
        String output = "Hi, my name is " + this.name + ", I am " + this.age + " years old and I work as a " + this.occupation;
        System.out.println(output); 
    }
}
class Employee extends Person {
    private String employeeID; 
    public Employee(String n, int a, String o, String e){
        super(n, a, o); 
        this.employeeID = e; 
    }
    public void setEmployeeID(String e){
        this.employeeID = e; 
    }
    public String getEmployeeID(){
        return this.employeeID; 
    }
    @Override
    public void introduce(){
        String output = "Hi, my name is " + GetName() + ", I am " + GetAge() + " years old, I work as a " + GetOccupation() + ", and my employee ID is " + this.employeeID;
        System.out.println(output); 
    }
}
public class Problem1 {
    public static void main(String args[]){
        Employee E = new Employee("Aryan", 20, "Software Engineer", "234212"); 
        E.introduce(); 
    }
}