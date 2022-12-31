package Java.Assignment_K;

import java.util.PriorityQueue;

class Book implements Comparable<Book>{
    private String name;
    private int id;
    private double price;

    Book(int id, String name, double price){
        this.id = id;
        this.price = price;
        this.name = name;
    }

    @Override
    public int compareTo(Book book) {
        return (int)(this.price - book.price);
    }

    @Override 
    public String toString(){
        return "BOOK " + this.id + " : " + this.name + " Price: " + this.price;
    }


}

public class PriorityQueueDemo2 {

    public static void main(String[] args) {
        PriorityQueue<Book> pq = new PriorityQueue<>();

        pq.add(new Book(1, "Java", 540.92));
        pq.add(new Book(2, "C++", 631.85));

        Book C_Book = new Book(3, "C", 493.33);
        pq.add(C_Book);

        pq.remove(C_Book);
        
        for(var book : pq){
            System.out.println(book);
        }
    }
}
