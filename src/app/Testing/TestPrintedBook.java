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

    }
}