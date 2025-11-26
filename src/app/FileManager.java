package app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileManager {
    
    public static void writeBooksToFile(String path, List<Book> books) {
        try {
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            
            for (Book book : books) {
                if (book instanceof PrintedBook) {
                    PrintedBook pb = (PrintedBook) book;
                    pw.println("Printed- " + pb.getTitle() + " - " + pb.getAuthor() + " - " + 
                              pb.getGenre() + " - " + pb.getPages());
                } else if (book instanceof AudioBook) {
                    AudioBook ab = (AudioBook) book;
                    pw.println("Audio /" + ab.getTitle() + "/ " + ab.getAuthor() + " / " + 
                              ab.getGenre() + " / " + ab.getLengthInMinutes());
                }
            }
            
            pw.close();
            fw.close();
            System.out.println("Books saved succesfully!!!!");
            
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}