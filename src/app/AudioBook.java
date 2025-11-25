package app;

import java.util.ArrayList;
import java.util.List;

public class AudioBook extends Book{

    private int lengthInMinutes;
    private static List<AudioBook> allAudioBooks = new ArrayList<>();
    private static int totalAudioMinutes = 0; 
    private static final double COST_PER_MINUTE = 5.0;

    public AudioBook(String title, String author, Genre genre, int lengthInMinutes){
        super(title, author, genre);
        this.lengthInMinutes = lengthInMinutes;
        allAudioBooks.add(this);
        totalAudioMinutes += lengthInMinutes;

    }
    public int getLengthInMinutes(){
        return lengthInMinutes;
    }


    public void setLengthInMinutes(int lengthInMinutes){
        totalAudioMinutes -= this.lengthInMinutes;
        this.lengthInMinutes = lengthInMinutes;
        totalAudioMinutes += lengthInMinutes;
    }
    public double getCost(){
        return lengthInMinutes * COST_PER_MINUTE;

    }
    public static List<AudioBook> getAllAudioBooks(){
        return allAudioBooks;
    }
    protected void storeBookInfo(String title, String author, Genre genre, double cost){
        allAudioBooks.add(this);
    }   
    public static double computeAverageLength(){
        if (allAudioBooks.isEmpty()){
            return 0.0;
        }
        return (double) totalAudioMinutes / allAudioBooks.size();

    }
    public static void displayLastThreeAudioBooks(){
        System.out.println(" The last 3 audio books");
        if (allAudioBooks.isEmpty()){
            System.out.println("No Audio books.");
            return;
        }
        int size = allAudioBooks.size();
        int start = Math.max(0, size - 3);
        for (int i = start; i < size; i++){
            AudioBook book = allAudioBooks.get(i);
            System.out.printf("%d. %s - %d min\n", (i - start +1), book.getTitle(), book.getLengthInMinutes());
        }
    }
    public static double getTotalAudioBookCost(){
        double total = 0.0;
        for (AudioBook book : allAudioBooks){
            total += book.getCost();
        }
        return total;
    }
    public static int getTotalAudioMinutes(){
    return totalAudioMinutes;
    }
}