package org.example;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Reader implements Runnable{
    private String name;
    private List<Book> readingRoomBooks;

    public Reader(String name, List<Book> readingRoomBooks) {
        this.name = name;
        this.readingRoomBooks = readingRoomBooks;
    }

    public void run() {
        for (Book book : readingRoomBooks) {
            synchronized (book) {
                try {
                    if(book.isForRoom()){
                        think(book);
                    }
                    else {
                        book.takeBook();
                        System.out.println(name + " take " + book.getTitle()+" to hands");
                        Thread.sleep(200);
                        System.out.println(name + " reading " + book.getTitle());
                        Thread.sleep(3000);
                        book.returnBook();
                        System.out.println(name + " returned from hands " + book.getTitle());
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    System.out.println(name+" cant take/return book, maybe library is closed. Info: "+Thread.getAllStackTraces());
                }

            }
        }
    }
    public void think(Book book){
        int thinkTime=200+ThreadLocalRandom.current().nextInt(500);
        try {
            System.out.println(name + " is thinking take/not take "+book.getTitle()+" for "+thinkTime+"ms");
            Thread.sleep(thinkTime);
        } catch (InterruptedException e) {
            System.out.println(name+" cant think, maybe stressful day. Info: "+Thread.getAllStackTraces());
        }
        int rand = ThreadLocalRandom.current().nextInt(10);
        if(rand<6){
            System.out.println(name + " dont want read "+book.getTitle()+" in room");
        }
        else{
            try {
                book.takeBook();
                System.out.println(name + " is reading " + book.getTitle()+" in room");
                Thread.sleep(5000);
                book.returnBook();
                System.out.println(name + " returned " + book.getTitle()+" to bookshelf");
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Something went wrong. Info:"+Thread.getAllStackTraces());
            }
        }
    }
}
