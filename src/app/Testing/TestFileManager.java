package app.Testing;
import app.*;
import java.util.ArrayList;
import java.util.List;

public class TestFileManager {
    public static void main(String[] args) {
        System.out.println("Testing FileManager ");
        
        List<Book> books = new ArrayList<>();
        books.add(new PrintedBook("Midnight Wangan", "Michiharu Kusunoki", Genre.ANIME, 1000));
        books.add(new PrintedBook("Initial D", "Shuichi Shigeno", Genre.ANIME, 678));
        books.add(new AudioBook("Vinland Saga ", "Makoto Yukimura", Genre.ANIME, 7589));
        
        System.out.println("Test: writeBooksToFile()");
        FileManager.writeBooksToFile("books.txt", books);
        
        System.out.println(" test complete!");
    }
}