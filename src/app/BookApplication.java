package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BookApplication implements BookOps{
    private List<Book> books;
    public BookApplication(){
        books = new ArrayList<>();
    }
    public void addBook(Book b){
        books.add(b);
    }
    public void displayLastSixBooks(){
        System.out.println("Last 6 Books added");
        int start = Math.max(0, books.size() - 6);
        for (int i = start; i < books.size(); i++){
            System.out.println((i - start + 1) + ". " + books.get(i));
        }
    }
    public Map<Genre, Integer> getBookCountByGenre(){
        Map<Genre, Integer> counts = new HashMap<>();
        for (Book book : books){
            Genre g = book.getGenre();
            if (counts.containsKey(g)) {
                counts.put(g, counts.get(g) + 1);
            } else {
                counts.put(g,1);
            }
        }
        return counts;
    }
    public double getTotalCost(){
        double total = 0;
        for (Book book: books){
            total += book.getCost();
        }
        return total;
    }
        public void removeBook(String title) {
        Book toRemove = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                toRemove = book;
                break;
            }

        }
        if (toRemove != null) {
            books.remove(toRemove);
            System.out.println("Book removed: " + title);
        } else {
            System.out.println("Book not found: " + title);

        }
    }
    
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the application.");
            return;
        }
        System.out.println("All Books ");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
        public void displayBooksByGenre(Genre g) {
        System.out.println("Books in Genre: " + g + " ");
        boolean found = false;
        for (Book book : books) {
            if (book.getGenre() == g) {
                System.out.println("  " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found within this genre");
        }
    }
    public void displayMenu() {
        System.out.println("BOOK APP MENU");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Display all books");
        System.out.println("4.Display last SIX books");
        System.out.println("5. Display Books by genre");
        System.out.println("6. Get book Count by genre");
        System.out.println("7. Get total cost");
        System.out.println("8.Exit");
        System.out.print("Enter your choice: ");
    }
}