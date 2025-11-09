package org.example;

public class Main {
    public static void main(String[] args) {
        BookList bl = new BookList();

        bl.addBook("Tutunamayanlar", "Oğuz Atay", "In Library", 123456789, 1972, 724);
        bl.printList();
        System.out.println("--------------------------------");
        bl.addBook("Hayvan Çiftliği", "George Orwell", "In Library", 13579, 1980, 386);
        bl.printList();

        System.out.println("--------------------------------");
        bl.removeBook(123456789);
        bl.printList();
    }
}