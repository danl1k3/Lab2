package org.example;


public class Book {
    private String title;
    private boolean isAvailable = true;
    private boolean isForRoom = true;

    public Book(String title,boolean flag) {
        this.title = title;
        isForRoom = flag;
    }
    public boolean isForRoom() {
        return isForRoom;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void takeBook() {
        while (!isAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
               System.out.println("Something went wrong! Cannot take book"+Thread.getAllStackTraces());
            }
        }
        isAvailable = false;

    }

    public void returnBook() {
        isAvailable = true;
        notify();
    }
}
