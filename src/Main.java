

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Movie> allMovies = JsonReader.loadMovies("src/data/movies.json");

        if (allMovies != null) {
            MovieApp app = new MovieApp(allMovies);
            app.start();
        }
    }
}