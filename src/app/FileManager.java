package app;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.FileReader;
import java.util.ArrayList;
public class FileManager {
    
    public static void writeBooksToFile(String path, List<Book> books) {
        try {
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            
            for (Book book : books) {
                if (book instanceof PrintedBook) {
                    PrintedBook pb = (PrintedBook) book;
                    pw.println("Printed," + pb.getTitle() + "," + pb.getAuthor() + "," + 
                              pb.getGenre() + "," + pb.getPages());
                } else if (book instanceof AudioBook) {
                    AudioBook ab = (AudioBook) book;
                    pw.println("Audio," + ab.getTitle() + "," + ab.getAuthor() + "," + 
                              ab.getGenre() + "," + ab.getLengthInMinutes());
                }
            }
            
            pw.close();
            fw.close();
            System.out.println("Books saved succesfully!!!!");
            
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
    public static List<Book> readBooksFromFile(String path) {
        List<Book> books = new ArrayList<>();
        
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length < 5) {
                    continue;
                }
                
                String type = parts[0];
                String title = parts[1];
                String author = parts[2];
                Genre genre = Genre.valueOf(parts[3]);
                
                if (type.equals("Printed")) {
                    int pages = Integer.parseInt(parts[4]);
                    books.add(new PrintedBook(title, author, genre, pages));
                } else if (type.equals("Audio")) {
                    int minutes = Integer.parseInt(parts[4]);
                    books.add(new AudioBook(title, author, genre, minutes));
                }
            }
            
            br.close();
            fr.close();
            System.out.println("Books successfully loaded");
            
        } catch (IOException e) {
            System.out.println("Error reading   file: " + e.getMessage());
        }
        
        return books;
    }
}