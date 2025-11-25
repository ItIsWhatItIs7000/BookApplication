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
}