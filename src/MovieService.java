import java.util.*;

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


    public List<Movie> findMoviesByActor(List<Movie> allMovies, String actorName) {
        Map<String, List<Movie>> map = new HashMap<>();
        for (Movie m : allMovies) {
            for (Cast c : m.getCast()) {
                map.putIfAbsent(c.getFullName(), new ArrayList<>());
                map.get(c.getFullName()).add(m);
            }
        }
        return map.getOrDefault(actorName, new ArrayList<>());
    }

    public List<Movie> findMoviesByDirector(List<Movie> allMovies, String directorName) {
        Map<String, List<Movie>> map = new HashMap<>();
        for (Movie m : allMovies) {
            String dName = m.getDirector().getFullName();
            map.putIfAbsent(dName, new ArrayList<>());
            map.get(dName).add(m);
        }
        return map.getOrDefault(directorName, new ArrayList<>());
    }

    public List<Movie> findMoviesByYear(List<Movie> allMovies, int year) {
        Map<Integer, List<Movie>> map = new HashMap<>();
        for (Movie m : allMovies) {
            map.putIfAbsent(m.getYear(), new ArrayList<>());
            map.get(m.getYear()).add(m);
        }
        return map.getOrDefault(year, new ArrayList<>());
    }

    public void printActorRoles(List<Movie> allMovies, String actorName) {
        System.out.println("Роли актера " + actorName + ":");
        for (Movie m : allMovies) {
            for (Cast c : m.getCast()) {
                if (c.getFullName().equalsIgnoreCase(actorName)) {
                    System.out.println("- Фильм: " + m.getName() + ", Роль: " + c.getRole());
                }
            }
        }
    }

    public void printAllCast(List<Movie> allMovies) {
        Set<String> allCast = new TreeSet<>();
        for (Movie m : allMovies) {
            for (Cast c : m.getCast()) {
                allCast.add(c.getFullName() + " (роль: " + c.getRole() + ")");
            }
        }
        allCast.forEach(System.out::println);
    }
}