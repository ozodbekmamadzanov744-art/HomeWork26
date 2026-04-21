import java.util.List;
import java.util.Scanner;
public class MovieApp {
    private final MovieService movieService = new MovieService();
    private final Scanner scanner = new Scanner(System.in);
    private List<Movie> movies;

    public MovieApp(List<Movie> movies) {
        this.movies = movies;
    }

    public void start() {
        while (true) {
            System.out.println("\n--- МЕНЮ КОЛЛЕКЦИИ ФИЛЬМОВ ---");
            System.out.println("1. Показать все фильмы");
            System.out.println("2. Найти фильм по названию");
            System.out.println("3. Сортировать по году (возрастание)");
            System.out.println("4. Сортировать по названию (А-Я)");
            System.out.println("5. Сортировать по режиссеру");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            handleChoice(choice);
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                printMovies(movies);
                break;
            case 2:
                System.out.print("Введите название для поиска: ");
                String query = scanner.nextLine();
                printMovies(movieService.findByName(movies, query));
                break;
            case 3:
                printMovies(movieService.sortByYearAscending(movies));
                break;
            case 4:
                printMovies(movieService.sortByName(movies));
                break;
            case 5:
                printMovies(movieService.sortByDirector(movies));
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private void printMovies(List<Movie> listToPrint) {
        if (listToPrint == null || listToPrint.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        for (Movie m : listToPrint) {
            System.out.println(m);
            System.out.println("---------------------------");
        }
    }
}
