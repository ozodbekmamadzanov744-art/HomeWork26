import java.util.List;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "src/data/movies.json";
        System.out.println("Загрузка базы фильмов...");
        List<Movie> allMovies = JsonReader.loadMovies(path);
        if (allMovies != null && !allMovies.isEmpty()) {
            MovieApp app = new MovieApp(allMovies);

            app.start();
        } else {
            System.out.println("Критическая ошибка: Файл не найден или пуст по пути: " + path);
            System.out.println("Убедитесь, что библиотека GSON подключена к проекту.");
        }
    }
}