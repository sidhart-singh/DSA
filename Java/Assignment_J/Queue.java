package Java.Assignment_J;

class QNode {
    int key;
    QNode next;

    QNode(int key) {
        this.key = key;
        this.next = null;
    }
}

public class Queue {
    QNode front;
    QNode rear;

    Queue(){
        this.front = null;
        this.rear = null;
    }

    void enqueue(int key){
        QNode node = new QNode(key);

        if(this.rear == null){
            this.front = node;
            this.rear = node;
            
            return;
        }

        this.rear.next = node;
        this.rear = node;
    }

    public void dequeue(){
        if(this.front == null){
            return;
        }

        QNode node = this.front;
        this.front = this.front.next;

        if(this.front == null){
            this.rear = null;
        }
    }
}
