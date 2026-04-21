import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
public class JsonReader {
    public static List<Movie> loadMovies(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            MovieList container = gson.fromJson(reader, MovieList.class);
            return container.getMovies();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
    }
}
