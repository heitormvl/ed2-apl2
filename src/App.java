import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // Create an instance of ProgramaNetFlix
        List<String> generos = Arrays.asList("Action", "Adventure");
        List<String> production_countries = Arrays.asList("USA", "UK");
        ProgramaNetFlix programa = new ProgramaNetFlix(1, "The Avengers", ProgramaNetFlix.ShowType.MOVIE,
                "Superheroes unite to save the world.", 2012, "PG-13", 143, generos, production_countries, 0,
                "tt0848228", 8, 1200000, 100, 9);

        // Print the string representation of the instance
        System.out.println(programa);
    }

}
