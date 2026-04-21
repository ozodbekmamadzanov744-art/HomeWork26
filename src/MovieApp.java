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
            System.out.println("\n======= МЕНЮ КОЛЛЕКЦИИ =======");
            System.out.println("1. Показать все фильмы");
            System.out.println("2. Поиск по названию (Задание 1)");
            System.out.println("3. Сортировка по году (возр.)");
            System.out.println("4. Сортировка по названию (А-Я)");
            System.out.println("------------------------------");
            System.out.println("5. Найти фильмы по АКТЕРУ (Задание 2)");
            System.out.println("6. Найти фильмы по РЕЖИССЕРУ");
            System.out.println("7. Найти фильмы по ГОДУ");
            System.out.println("8. Показать роли актера в фильмах");
            System.out.println("9. Список всех актеров (без дублей)");
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
                System.out.print("Введите название фильма: ");
                String title = scanner.nextLine();
                printMovies(movieService.findByName(movies, title));
                break;
            case 3:
                printMovies(movieService.sortByYearAscending(movies));
                break;
            case 4:
                printMovies(movieService.sortByName(movies));
                break;
            case 5:
                System.out.print("Введите имя актера: ");
                String actor = scanner.nextLine();
                // Используем поиск через Map из MovieService
                printMovies(movieService.findMoviesByActor(movies, actor));
                break;
            case 6:
                System.out.print("Введите имя режиссера: ");
                String director = scanner.nextLine();
                printMovies(movieService.findMoviesByDirector(movies, director));
                break;
            case 7:
                System.out.print("Введите год выпуска: ");
                int year = scanner.nextInt();
                printMovies(movieService.findMoviesByYear(movies, year));
                break;
            case 8:
                System.out.print("Введите имя актера для поиска ролей: ");
                String actorName = scanner.nextLine();
                movieService.printActorRoles(movies, actorName);
                break;
            case 9:
                System.out.println("Список всех актеров и их ролей:");
                movieService.printAllCast(movies);
                break;
            default:
                System.out.println("Неверный ввод.");
        }
    }

    private void printMovies(List<Movie> listToPrint) {
        if (listToPrint == null || listToPrint.isEmpty()) {
            System.out.println("Ничего не найдено.");
            return;
        }
        for (Movie m : listToPrint) {
            System.out.println(m);
            System.out.println("---------------------------");
        }
    }
}