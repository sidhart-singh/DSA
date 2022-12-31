package Java.Practical;

class InsufficientBalanceException extends RuntimeException{
    InsufficientBalanceException(){
        super("Insufficient Balance");
    }

    InsufficientBalanceException(String msg){
        super(msg);
    }
}

public class CheckingAccount {
    double balance;

    CheckingAccount(double balance){
        this.balance = balance;
    }

    public void moneyWithdraw(double withdrawAmount) throws InsufficientBalanceException{
        if(withdrawAmount > this.balance){
            throw new InsufficientBalanceException();
        } else {
            this.balance -= withdrawAmount;
            System.out.println("moneyWithdraw(): " + this.balance);
        }
    }

    public void moneyDeposit(double depositAmount){
        this.balance += depositAmount;
        System.out.println("moneyDeposit(): " + this.balance);
    }
    
    public static void main(String[] args) {
        
        CheckingAccount ca = new CheckingAccount(231.89);
        ca.moneyDeposit(350.51);
        ca.moneyWithdraw(500);

        try{
            ca.moneyWithdraw(300);
        }catch(InsufficientBalanceException e){
            // e.printStackTrace();
            System.out.println(new InsufficientBalanceException());
        }
    }
}