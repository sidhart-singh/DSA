package Java.Assignment_G;

interface Calculator{
    public void sum();

    public void multi();
}

interface Calculator2 extends Calculator{
    // default implemention for sum() :
    // abstract method of parent interface
    default void sum(){
        System.out.println("Sum from interface");
    }
}

class MyCalculator implements Calculator2{
    // Not required to override :
    // default implementation already defined
    public void sum(){
        System.out.println("Sum()");
    }

    public void multi(){
        System.out.println("multi()");
    }
}

public class InterfaceCalculator {
    public static void main(String[] args) {
        Calculator newCalculator = new MyCalculator();

        newCalculator.sum();
        newCalculator.multi();
        
    }
}
