package app.Testing;
import app.*;

public class TestAudioBook{
    public static void main(String[] args){
        System.out.println("AudioBook test");

        AudioBook book1 = new AudioBook("1984", "Geroge Orwell", Genre.FICTION, 328);
        System.out.println(" Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());
        System.out.println("Genre: " + book1.getGenre());
        System.out.println("Length: " + book1.getLengthInMinutes());
        System.out.println("Cost: $" + book1.getCost()+ " USD");


        AudioBook book2 = new AudioBook("Dune", "Herbert", Genre.SCIFI, 676);
        AudioBook book3 = new AudioBook("One Piece", "Oda", Genre.FANTASY, 767);
        System.out.println("Total Books: " + AudioBook.getAllAudioBooks().size());

        System.out.println("Recap of all Audio Books");
        for (AudioBook book : AudioBook.getAllAudioBooks()){
            System.out.println(book.getTitle()+ " - " + book.getLengthInMinutes() + " minutes ($ " + book.getCost() + ")" );

        }

        System.out.println(" Test of: computeAverageLength:");
        System.out.printf("Average Length: %.2f\n", AudioBook.computeAverageLength());
        System.out.println(" Test of: DisplayLastThreeAudioBooks:");
        AudioBook.displayLastThreeAudioBooks();
        System.out.println(" Test of: getTotalAudioBookCost:");
        System.out.printf("Total cost of all the audio books: $%.2f\n", AudioBook.getTotalAudioBookCost());

    }
}