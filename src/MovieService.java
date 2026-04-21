import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class MovieService {
    public List<Movie> findByName(List<Movie> allMovies, String query) {
        List<Movie> result = new ArrayList<>();

        String lowerCaseQuery = query.toLowerCase();

        for (Movie movie : allMovies) {
            if (movie.getName().toLowerCase().contains(lowerCaseQuery)) {
                result.add(movie);
            }
        }
        return result;
    }

    public List<Movie> sortByYearAscending(List<Movie> allMovies) {

        List<Movie> sortedList = new ArrayList<>(allMovies);


        sortedList.sort(Comparator.comparingInt(Movie::getYear));

        return sortedList;
    }

    public List<Movie> sortByYearDescending(List<Movie> allMovies) {
        List<Movie> sortedList = new ArrayList<>(allMovies);

        sortedList.sort(Comparator.comparingInt(Movie::getYear).reversed());

        return sortedList;
    }

    public List<Movie> sortByName(List<Movie> allMovies) {
        List<Movie> sortedList = new ArrayList<>(allMovies);
        sortedList.sort(Comparator.comparing(Movie::getName, String.CASE_INSENSITIVE_ORDER));
        return sortedList;
    }


    public List<Movie> sortByDirector(List<Movie> allMovies) {
        List<Movie> sortedList = new ArrayList<>(allMovies);
        sortedList.sort(Comparator.comparing(m -> m.getDirector().getFullName()));
        return sortedList;
    }
}
