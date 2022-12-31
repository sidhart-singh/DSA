package Java.Assignment_J;

public class Main {
    public static void main(String[] args) {

        // Queue.java
        // Queue q = new Queue();
        // q.enqueue(10);
        // q.enqueue(20);
        // // q.dequeue();

        // System.out.println("Queue Front : " + q.front.key);
        // System.out.println("Queue Rear : " + q.rear.key);

        // QueueLL.java
        QueueLL customerQueue = new QueueLL();
        customerQueue.enqueue(new Customer(3, 22, "sid"));
        customerQueue.enqueue(new Customer(9, 32, "nis"));
        customerQueue.enqueue(new Customer(3, 22, "sid"));
        customerQueue.enqueue(new Customer(3, 22, "sid"));
        
        try{
            System.out.println("Removed: " + customerQueue.dequeue());;
        } catch(QueueEmptyException e) {
            System.out.println(new QueueEmptyException("Queue is empty"));
        }

        System.out.println("Queue: ");
        customerQueue.display();

        customerQueue.modify(9, new Customer(8, 21, "Pra"));
        
        System.out.println("Queue: ");
        customerQueue.display();
    }
}
