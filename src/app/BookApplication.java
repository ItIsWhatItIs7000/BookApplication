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
}