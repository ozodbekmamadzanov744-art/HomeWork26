import java.util.List;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "src/data/movies.json";

        File file = new File(path);
        if (!file.exists()) {
            path = "movies.json";
        }

        System.out.println("Попытка загрузки файла из: " + new File(path).getAbsolutePath());
        List<Movie> allMovies = JsonReader.loadMovies(path);

        if (allMovies != null && !allMovies.isEmpty()) {
            System.out.println("Фильс загружен: " + allMovies.size());

            MovieApp app = new MovieApp(allMovies);

            app.start();
        } else {
            System.out.println("ОШИБКА.");
        }
    }
}