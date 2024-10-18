import java.util.ArrayList; 
import java.util.List;
abstract class Person {
    String name; 
    String email; 
    public Person(String n, String e){
        this.name = n; 
        this.email = e; 
    }
    public abstract void introduce(); 
}
interface enrollable {
    public void enroll(Course course);
}
class Instructor extends Person {
    String subject; 
    public Instructor(String n, String e, String s){
        super(n, e);
        this.subject = s; 
    }
    @Override
    public void introduce() {
        System.out.println("Hello, I am " + this.name + ", and I teach " + this.subject + ".");
    }
}
class Student extends Person implements enrollable{
    String studentID; 
    List <Course> enrolledCourses= new ArrayList<>(); 
    public Student(String n, String e, String ID){
        super(n, e);
        this.studentID = ID; 
    }
    @Override
    public void introduce(){
        System.out.println("Hi, I am " + this.name + ", and my student ID is " + this.studentID); 
    }
    @Override 
    public void enroll(Course course){
        enrolledCourses.add(course); 
    }
}
class Course {
    String courseName; 
    String courseCode; 
    Instructor instructor; 
    List <Student> studentsEnrolled = new ArrayList<>(); 
    public Course (String cn, String cd){
        this.courseName = cn; 
        this.courseCode = cd;
    }
    public void assignInstructor(Instructor i){
        instructor = i; 
        System.out.println("Course " + this.courseCode + ", " + this.courseName + " has instructor " + i.name); 
    }
    public void enrollStudent(Student student){
        studentsEnrolled.add(student); 
        student.enroll(this); 
    }
    public void displayCourseDetails() {
        System.out.println(this.courseCode + ", " + this.courseName + ", Instructor: " + (instructor != null ? instructor.name : "No instructor assigned") + ", Students: ");
        int counter = 1; 
        for (Student s : studentsEnrolled) {
            System.out.println(counter + ") " + s.name);
            counter++;
        }

    }
}
public class CourseManagementSystem {
    public static void main(String args[]){
        Instructor A = new Instructor("Dr. Alan", "alanwalker5@gmail.com", "Computer Science");
        Student B = new Student("Emma", "emmapage17@gmail.com", "S12345"); 
        Course course1 = new Course("Intro to Java", "CS101");
        course1.assignInstructor(A); 
        course1.enrollStudent(B);
        course1.displayCourseDetails(); 
    }
}