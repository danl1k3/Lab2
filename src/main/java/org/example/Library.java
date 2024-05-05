package org.example;

import java.util.*;

public class Library {
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        boolean Room=true,Hands=false;
        library.add(new Book( "1984",Room));
        library.add(new Book( "To Kill a Mockingbird",Hands));
        library.add(new Book("The Great Gatsby", Room));
        library.add(new Book("Pride and Prejudice", Hands));
        library.add(new Book("Jane Eyre", Room));
        library.add(new Book("The Odyssey", Room));
        library.add(new Book("Frankenstein", Hands));

        Reader reader1 = new Reader("Reader 1",library);
        Reader reader2 = new Reader("Reader 2",library);
        Reader reader3 = new Reader("Reader 3",library);

        Thread t1 = new Thread(reader1);
        Thread t2 = new Thread(reader2);
        Thread t3 = new Thread(reader3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong! Cannot end excuting. Info"+Thread.getAllStackTraces());
        }
    }
}
