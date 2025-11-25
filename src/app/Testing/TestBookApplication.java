package app.Testing;
import app.*;
import java.util.Map;

public class TestBookApplication{
    public static void main(String[] args){
        System.out.println(" Test BookApplication");
        BookApplication app = new BookApplication();

        System.out.println("ADDING BOOKS");
        app.addBook(new PrintedBook("20000 Leguas de viaje Submarino", "Julio Verne", Genre.FICTION, 328));
        app.addBook(new PrintedBook("lORD OF tHE rINGS", "Tolkien", Genre.FANTASY, 348));
        app.addBook(new PrintedBook("Brave NEW World", "Huxley", Genre.SCIFI, 346));
        app.addBook(new PrintedBook("Animal Farm", "Orwell", Genre.FICTION, 836));
        app.addBook(new PrintedBook("Farenheit 451", "Bradbury", Genre.SCIFI, 743));
        app.addBook(new PrintedBook("Pedro Paramo", "Juan Rulfo", Genre.FICTION, 326));
        app.addBook(new PrintedBook("The Hobbit", "Tolkien", Genre.FANTASY, 444));
        System.out.println("7 Books succesfuly added");

        System.out.println("Test: displayLastSixBooks()");
        app.displayLastSixBooks();

        System.out.println("Test: getBookcountByGenre()");
        Map<Genre, Integer> genreCounts = app.getBookCountByGenre();
        System.out.println("Books separated by genre:");
        for (Map.Entry<Genre, Integer> entry : genreCounts.entrySet()){
            System.out.println("  "+entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Test: getTotalCost()");
        System.out.printf("Total costs of all books: $%.2f\n", app.getTotalCost());
        System.out.println("If I can see this we coolio");

    }
}