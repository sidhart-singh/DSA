package Java.Assignment_J;

import java.util.LinkedList;

class Customer {
    int id;
    int age;
    String name;

    Customer(int id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", age=" + age + ", name=" + name + "]";
    }
    
}

class QueueEmptyException extends RuntimeException {
    QueueEmptyException(){
        super("Queue is empty");
    }

    QueueEmptyException(String msg){
        super(msg);
    }
}

public class QueueLL{
    
    private LinkedList<Customer> queue = new LinkedList<>();

    public void enqueue(Customer c){
        queue.add(c);
    }

    public Customer dequeue() throws QueueEmptyException{
        if(queue.isEmpty()){
            throw new QueueEmptyException();
        } else {
            return queue.remove();
        }
    }

    public void modify(int id, Customer modCustomer){
        for(var customer : queue){
            if(customer.id == id){
                // Assignment doesnt modifies :
                // customer = modCustomer;

                customer.id = modCustomer.id;
                customer.age = modCustomer.age;
                customer.name = modCustomer.name;
                System.out.println("Item Modified");
                return;
            }
        }
        System.out.println("No such Item");
    }

    public void display(){
        for(var customer : queue){
            System.out.println(customer);
        }
    }
}


