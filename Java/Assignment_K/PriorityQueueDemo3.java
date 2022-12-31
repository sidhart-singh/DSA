package Java.Assignment_K;

import java.util.Comparator;
import java.util.PriorityQueue;

class Book1 {
    String name;
    int id;
    double price;

    Book1(int id, String name, double price){
        this.id = id;
        this.price = price;
        this.name = name;
    }

    @Override 
    public String toString(){
        return "BOOK " + this.id + " : " + this.name + " Price: " + this.price;
    }
}

public class PriorityQueueDemo3 {

    public static void main(String[] args) {
        //Priority Queue with a custom comparator
        PriorityQueue<Book1> pq1 = new PriorityQueue<>(new Comparator<Book1>() {
            @Override
            public int compare(Book1 book1, Book1 book2){
                return (int)(book1.price - book2.price);
            }
        });

        pq1.add(new Book1(1, "Java", 540.92));
        pq1.add(new Book1(2, "C++", 631.85));
        pq1.add(new Book1(3, "C", 493.33));

        for(var book : pq1){
            System.out.println(book);
        }
    }

}
