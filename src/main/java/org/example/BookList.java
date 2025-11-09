package org.example;

public class BookList {
    BookInfo first;
    BookInfo last;

    BookList() {
        first = null;
        last = null;
    }

    void addBook(String bookName, String authorName, String bookStatus, int barcodeNumber, int publicationYear, int numberOfPages) {
        BookInfo newBook = new BookInfo(bookName, authorName, bookStatus, barcodeNumber, publicationYear, numberOfPages);
        if (first == null) {
            first = newBook;
            last = newBook;
        } else {
            last.forward = newBook;
            last = newBook;
        }
    }

    void removeBook(int barcodeNumber) {
        BookInfo temp = first;
        BookInfo before = null;

        while (temp != null) {
            if (temp.barcodeNumber == barcodeNumber) {
                if (temp == first) {
                    first = temp.forward;
                }
                else if (temp == last) {
                    last = before;
                    before.forward = null;
                }
                else {
                    before.forward = temp.forward;
                }
                System.out.println("Kitap silindi: " + temp.bookName);
                return;
            }
            before = temp;
            temp = temp.forward;
        }
        System.out.println("Barkod numarası bulunamadı.");
        }

    void printList() {
        BookInfo temp = first;

        while (temp != null) {
            System.out.println("Book Name :" + temp.bookName + "\nAuthor Name :" + temp.authorName + "\nBook Status : " + temp.bookStatus + "\nBarcode Number : " + temp.barcodeNumber + "\nNumber Of Pages : " + temp.numberOfPages + "\nPublication Year : " + temp.publicationYear);
            temp = temp.forward;
        }
    }
}
