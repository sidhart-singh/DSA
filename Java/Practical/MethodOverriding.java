package Java.Practical;

class Animal {
    public void sound(){
        System.out.println("Different sound of animal varies..");    

    }
}
class Tiger extends Animal{
    public void sound(){
        System.out.println("Roaring...");
    }
}
class Dog extends Animal{
public void sound(){
    System.out.println("Barking...");
}  
}

public class MethodOverriding {
   public static void main(String[] args) {
        Animal obj = new Animal();
        Animal obj1 = new Tiger();
        Animal obj2 = new Dog();

        obj.sound();
        obj1.sound();
        obj2.sound();
   }
}
