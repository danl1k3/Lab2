package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void testConstructor() {
        String title = "The Catcher in the Rye";
        boolean flag = false;
        Book book = new Book(title, flag);

        assertEquals(title, book.getTitle());
        assertEquals(flag, book.isForRoom());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testIsForRoom() {
        Book book = new Book("1984", true);
        assertTrue(book.isForRoom());

        book = new Book("Brave New World", false);
        assertFalse(book.isForRoom());
    }

    @Test
    public void testGetTitle() {
        String title = "Moby Dick";

        Book book = new Book(title, true);

        assertEquals(title, book.getTitle());
    }
}