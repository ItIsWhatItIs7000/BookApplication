package app.testing;
public class TestBook{
    public static void main(String[] args){
        System.out.println("Testing Genre.java");
        Genre fiction = Genre.FICTION;
        System.out.println(" genre: " + fiction);
        Genre unknown  = Genre.fromString("blahblahtesting testing");
        System.out.println("This random thing should default to: " + unknown);
        System.out.println("We gonna test Book using a rreal book class now.");
        // we will need a real type of book later
        System.out.println("Book is abstractwewill test with PrintedBook later");
         System.out.println("everything in order man");

    }
}