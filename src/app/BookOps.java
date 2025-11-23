package app;
import java.util.Map;
public interface BookOps{
    void displayLastSixBooks();

    Map<Genre, Integer> getBookCountByGenre();

    double getTotalCost();
}
