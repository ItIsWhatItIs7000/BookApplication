package app;

import java.util.ArrayList;
import java.util.List;

public class PrintedBook extends Book{

    private int pages;
    private static List<PrintedBook> allPrintedBooks = new ArrayList<>();
    private static final double COST_PER_PAGE = 10.0;

    public PrintedBook(String title, String author, Genre genre, int pages){
        super(title, author, genre);
        this.pages = pages;
        allPrintedBooks.add(this);

    }
    public int getPages(){
        return pages;
    }


    public void setPages(int pages){
        this.pages = pages;
    }
    public double getCost(){
        return pages * COST_PER_PAGE;

    }
    public static List<PrintedBook> getAllPrintedBooks(){
        return allPrintedBooks;
    }
    protected void storeBookInfo(String title, String author, Genre genre, double cost){
        allPrintedBooks.add(this);
    }   
    public static double computeAveragePages(){
        if (allPrintedBooks.isEmpty()){
            return 0.0;
        }
        int totalPages = 0;
        for (PrintedBook book : allPrintedBooks){
            totalPages += book.getPages();
        }
        return (double) totalPages / allPrintedBooks.size();

    }
    public static void displayLastThreePrintedBooks(){
        System.out.println(" The last 3 printned books");
        if (allPrintedBooks.isEmpty()){
            System.out.println("No printed books.");
            return;
        }
        int size = allPrintedBooks.size();
        int start = Math.max(0, size - 3);
        for (int i = start; i < size; i++){
            PrintedBook book = allPrintedBooks.get(i);
            System.out.printf("%d. %s - %d pages\n", (i - start +1), book.getTitle(), book.getPages());
        }
    }
    public static double getTotalPrintedBookCost(){
        double total = 0.0;
        for (PrintedBook book : allPrintedBooks){
            total += book.getCost();
        }
        return total;
    }
}