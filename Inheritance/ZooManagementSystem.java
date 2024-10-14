abstract class Animal {
    String name; 
    String species; 
    int age; 
    public Animal(String n, String s, int a){
        this.name = n; 
        this.species = s; 
        this.age = a; 
    }
    abstract void makeSound(); 
    public void eat() {
        System.out.println("The " + this.species + " named " + this.name + " is eating."); 
    }
    public void sleep() {
        System.out.println("The " + this.species + " named " + this.name + " is sleeping.");
    }
}
interface Trainable {
    void performTrick();
}
class Lion extends Animal {
    public Lion(String n, int a){super(n, "Lion", a);}
    @Override 
    public void makeSound() {
        System.out.println("Roar!");
    }
}
class Parrot extends Animal implements Trainable {
   public Parrot(String n, int a) {super(n, "Parrot", a);}
    @Override 
    public void makeSound() {
        System.out.println("Squawk!"); 
    }
    @Override 
    public void performTrick(){
        System.out.println("The parrot named " + this.name + " is doing a flip!"); 
    }
} 
class Dolphin extends Animal implements Trainable {
    public Dolphin(String n, int a) {super(n, "Dolphin", a);}
    @Override 
    public void makeSound(){
        System.out.println("Click-click!");
    }
    @Override 
    public void performTrick(){
        System.out.println("The dolphin named " + this.name + " is jumping through a hoop!"); 
    }
}
public class ZooManagementSystem {
    public static void main(String args []){
        Animal [] a = new Animal[3];
        a[0] = new Parrot("Anda", 5);
        a[1] = new Lion("Carlos", 3);
        a[2] = new Dolphin("Jeff", 2);
        for(int i = 0; i < a.length ; i++){
            a[i].makeSound();
            a[i].eat(); 
            a[i].sleep(); 
            if(a[i] instanceof Trainable){
                ((Trainable) a[i]).performTrick(); 
            }
        }
    }
}