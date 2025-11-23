package org.example;
import java.util.Scanner;


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
                System.out.println("Book Deleted: " + temp.bookName);
                return;
            }
            before = temp;
            temp = temp.forward;
        }
        System.out.println("Barcode number not found.");
        }
    void searchBook(){
        BookInfo temp = first;
        if(temp == null){
            System.out.println("There is no book on the list");
            return;
        }
        System.out.println("Select your search filter \n1-)Book Name\n2-)Author Name\n3-)Barcode Number ");

        Scanner input = new Scanner(System.in);

        String filter = input.nextLine();

        if(filter.equals("1")){
            System.out.println("Enter the book name");
            String bookname = input.nextLine();
            while(temp!=null){
                if(bookname.equals(temp.bookName)){
                    System.out.println("Book Name :" + temp.bookName + "\nAuthor Name :" + temp.authorName + "\nBook Status : " + temp.bookStatus + "\nBarcode Number : " + temp.barcodeNumber + "\nNumber Of Pages : " + temp.numberOfPages + "\nPublication Year : " + temp.publicationYear);
                    return;
                }
                temp = temp.forward;
            }
        }
        else if(filter.equals("2")){
            System.out.println("Enter the author's name");
            String authorname = input.nextLine();
            while(temp != null){
                if(authorname.equals(temp.authorName)){
                    System.out.println("Book Name :" + temp.bookName + "\nAuthor Name :" + temp.authorName + "\nBook Status : " + temp.bookStatus + "\nBarcode Number : " + temp.barcodeNumber + "\nNumber Of Pages : " + temp.numberOfPages + "\nPublication Year : " + temp.publicationYear);
                    return;
                }
                temp = temp.forward;
            }
        }
        else if(filter.equals("3")){
            System.out.println("Enter the barcode number");
            String barcodenumber = input.nextLine();
            while(temp != null){
                if(barcodenumber.equals(temp.barcodeNumber)){
                    System.out.println("Book Name :" + temp.bookName + "\nAuthor Name :" + temp.authorName + "\nBook Status : " + temp.bookStatus + "\nBarcode Number : " + temp.barcodeNumber + "\nNumber Of Pages : " + temp.numberOfPages + "\nPublication Year : " + temp.publicationYear);
                    return;
                }
                temp=temp.forward;
            }
        }
    }

    void printList() {
        BookInfo temp = first;

        while (temp != null) {
            System.out.println("Book Name :" + temp.bookName + "\nAuthor Name :" + temp.authorName + "\nBook Status : " + temp.bookStatus + "\nBarcode Number : " + temp.barcodeNumber + "\nNumber Of Pages : " + temp.numberOfPages + "\nPublication Year : " + temp.publicationYear);
            temp = temp.forward;
        }
    }
}
