package app.Testing;
import app.*;

public class TestPrintedBook{
    public static void main(String[] args){
        System.out.println("PrintedBook test");

        PrintedBook book1 = new PrintedBook("1984", "Geroge Orwell", Genre.FICTION, 328);
        System.out.println(" Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());
        System.out.println("Genre: " + book1.getGenre());
        System.out.println("Pages: " + book1.getPages());
        System.out.println("Cost: $" + book1.getCost()+ " USD");


        PrintedBook book2 = new PrintedBook("Dune", "Herbert", Genre.SCIFI, 676);
        PrintedBook book3 = new PrintedBook("One Piece", "Oda", Genre.FANTASY, 767);
        System.out.println("Total Books: " + PrintedBook.getAllPrintedBooks().size());

        System.out.println("Recap of all Prinetd Books");
        for (PrintedBook book : PrintedBook.getAllPrintedBooks()){
            System.out.println(book.getTitle()+ " - " + book.getPages() + " pages ($ " + book.getCost() + ")" );

        }

        System.out.println(" Test of: computeaveragePages:");
        System.out.printf("Average pages: %.2f\n", PrintedBook.computeAveragePages());
        System.out.println(" Test of: DisplayLastThreePrintedBooks:");
        PrintedBook.displayLastThreePrintedBooks();


    }
}