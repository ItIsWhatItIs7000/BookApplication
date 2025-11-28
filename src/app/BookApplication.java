package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner; 

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
    public void saveBooksToFile(String path) {
    FileManager.writeBooksToFile(path, books);
}

public void loadBooksFromFile(String path) {
    List<Book> loadedBooks = FileManager.readBooksFromFile(path);
    for (Book book : loadedBooks) {
        books.add(book);
    }
    System.out.println("Books loaded from file.");
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
        System.out.println("8. Save books to file");
        System.out.println("9. Load books from file");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }
        public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                System.out.print("Book type (1=Printed, 2=Audio): ");
                int type = scanner.nextInt();
                scanner.nextLine();
                
                System.out.print("Title:");
                String title = scanner.nextLine();
                
                System.out.print("Author: ");
                String author = scanner.nextLine();
                
                System.out.print("Genre (FICTION, NONFICTION, MYSTERY, SCIENCE, HISTORY, BIOGRAPHY, ROMANCE, DRAMA, FANTASY, SCIFI, ANIME, OTHER): ");
                String genreStr = scanner.nextLine();
                Genre genre = Genre.valueOf(genreStr.toUpperCase());
                
                if (type == 1) {
                    System.out.print("Pages:  ");
                    int pages = scanner.nextInt();
                    scanner.nextLine();
                    addBook(new PrintedBook(title, author, genre, pages));
                } else if (type == 2) {
                    System.out.print("Length in min ");
                    int minutes = scanner.nextInt();
                    scanner.nextLine();
                    addBook(new AudioBook(title, author, genre, minutes));
                }
                System.out.println("Book added (▀̿Ĺ̯▀̿ ̿) ");
                
            } else if (choice == 2) {
                System.out.print("Enter title to dlte: ");
                String title = scanner.nextLine();
                removeBook(title);
                
            } else if (choice == 3) {
                displayAllBooks();
                
            } else if (choice == 4) {
                displayLastSixBooks();
                
            } else if (choice == 5) {
                System.out.print("Enter genre:");
                String genreStr = scanner.nextLine();
                Genre genre = Genre.valueOf(genreStr.toUpperCase());
                displayBooksByGenre(genre);
                
            } else if (choice == 6) {
                Map<Genre, Integer> counts = getBookCountByGenre();
                System.out.println("Book count by genre. ");
                for (Map.Entry<Genre, Integer> entry : counts.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                
            } else if (choice == 7) {
                System.out.printf("\nTotal Cost: $%.2f\n", getTotalCost());
                
            } else if (choice == 8) {
                System.out.print("Enter file path to save: ");
                String path = scanner.nextLine();
                saveBooksToFile(path);
                
            } else if (choice == 9) {
                System.out.print("Enter file path to load: ");
                String path = scanner.nextLine();
                loadBooksFromFile(path);
                
            } else if (choice == 10) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice. Pls try again man.");
            }
        }
        
        scanner.close();
    }
    public static void main(String[] args) {
        BookApplication app = new BookApplication();
        
        System.out.println("Welcome to the book App!");
        System.out.println("Uploading Examples");
        
        app.addBook(new PrintedBook("1984", "George Orwell", Genre.FICTION, 328));
        app.addBook(new PrintedBook("Sophie's World", "Jostein Gaarder", Genre.OTHER, 283));
        app.addBook(new AudioBook("The Selfish Gene", "Richard Dawkins", Genre.SCIENCE, 900));
        
        System.out.println("3 sample books were added (▀̿Ĺ̯▀̿ ̿)");
        
        app.run();
    }
}  
