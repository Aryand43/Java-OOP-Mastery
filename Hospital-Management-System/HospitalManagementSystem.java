abstract class Person {
    String name; 
    int age; 
    public Person(String n, int a){
        this.name=n;
        this.age=a;
    }
    public abstract void introduce();
    public void getAgeCategory(){
        if(this.age < 18){
            System.out.println("Child");
        }else if (this.age >= 18 && this.age < 65){
            System.out.println("Adult");
        }else {
            System.out.println("Senior"); 
        }
    }
}
interface Payable {
    void calculatePay(); 
}
class Doctor extends Person implements Payable{
    String specialization; 
    double consultationFee; 
    public Doctor(String n, int a, String s, double c){
        super(n, a); 
        this.specialization = s; 
        this.consultationFee = c; 
    }
    @Override
    public void introduce(){
        System.out.println("I am Dr. " + this.name + ", a " + this.specialization + " specialist.");
    }
    @Override 
    public void calculatePay() {
        double pay = this.consultationFee * 10; 
        System.out.println("Doctor pay is approximately " + pay);
    }
}
class Nurse extends Person implements Payable{
    double hourlyRate; 
    int hoursWorked; 
    public Nurse(String n, int a, double hr, int hw){
        super(n, a);
        this.hourlyRate = hr; 
        this.hoursWorked = hw; 
    }
    @Override 
    public void introduce(){
        System.out.println("I am " + this.name + ", a nurse.");
    }
    @Override 
    public void calculatePay(){
        double pay = this.hourlyRate * this.hoursWorked; 
        System.out.println("Nurse pay is approximately " + pay);
    }
}
class Patient extends Person {
    String ailment;
    Doctor doctorAssigned; 
    public Patient(String n, int a, String ail, Doctor d){
        super(n, a); 
        this.ailment = ail; 
        this.doctorAssigned = d; 
    }
    @Override 
    public void introduce(){
        System.out.println("I am " + this.name + ", and I am being treated for " + this.ailment + " by Dr. " + doctorAssigned.name);
    }
}
public class HospitalManagementSystem{
    public static void main (String args[]){
        Person p[] = new Person[3]; 
        p[0] = new Doctor("Smith", 40, "Cardiology", 100);
        p[1] = new Nurse("Nina", 29, 20.0, 40);
        p[2] = new Patient("John", 26, "flu", (Doctor) p[0]);
        for (Person person : p){
            person.introduce(); 
            if(person instanceof Payable){
                ((Payable) person).calculatePay(); 
            }
            System.out.println(); 
        }
    }
}