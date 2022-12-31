package Java.Assignment_G;

abstract class Bank {
    abstract double getRateOfInterest();

    String getBankName(){
        return "NoSpecialisedBank";
    }
}

class MySBI extends Bank{
    public double getRateOfInterest(){
        return 8.35;
    }

    public String getBankName(){
        return "SBI";
    }
}

class MyPNB extends Bank{
    public double getRateOfInterest(){
        return 7.35;
    }

    public String getBankName(){
        return "PNB";
    }
}

public class AbstractBank{
    public static void main(String[] args){
        Bank bank;

        bank = new MySBI();
        System.out.println("Bank Name: " + bank.getBankName());
        System.out.println("Rate of Interest: " + bank.getRateOfInterest() + "%");

        bank = new MyPNB();
        System.out.println("Bank Name: " + bank.getBankName());
        System.out.println("Rate of Interest: " + bank.getRateOfInterest() + "%");
    }
}
