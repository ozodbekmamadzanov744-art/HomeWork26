import java.util.List;
import java.util.Scanner;

public class MovieApp {
    private final MovieService movieService = new MovieService();
    private final Scanner scanner = new Scanner(System.in);
    private final List<Movie> mainCollection;

    public MovieApp(List<Movie> movies) {
        this.mainCollection = movies;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== СИСТЕМА УПРАВЛЕНИЯ КИНОТЕКОЙ ===");
            System.out.println("1. Показать все фильмы");
            System.out.println("2. Поиск по названию");
            System.out.println("3. Сортировки основной коллекции (Год/Имя/Режиссер)");
            System.out.println("4. Поиск фильмов по АКЕРУ");
            System.out.println("5. Поиск фильмов по РЕЖИССЕРУ");
            System.out.println("6. Поиск фильмов по ГОДУ");
            System.out.println("7. Список всех актеров и ролей");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;
            handleChoice(choice);
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                printMovies(mainCollection);
                break;
            case 2:
                System.out.print("Введите название: ");
                processSelection(movieService.findByName(mainCollection, scanner.nextLine()));
                break;
            case 3:
                showSortMenu();
                break;
            case 4:
                System.out.print("Имя актера: ");
                processSelection(movieService.findMoviesByActor(mainCollection, scanner.nextLine()));
                break;
            case 5:
                System.out.print("Имя режиссера: ");
                processSelection(movieService.findMoviesByDirector(mainCollection, scanner.nextLine()));
                break;
            case 6:
                System.out.print("Год: ");
                processSelection(movieService.findMoviesByYear(mainCollection, scanner.nextInt()));
                break;
            case 7:
                movieService.printAllCast(mainCollection);
                break;
            default:
                System.out.println("Ошибка выбора.");
        }
    }

    private void processSelection(List<Movie> selection) {
        if (selection.isEmpty()) {
            System.out.println("Ничего не найдено.");
            return;
        }
        printMovies(selection);

        System.out.println("\n[БОНУС] Желаете отсортировать этот результат?");
        System.out.println("1. По году | 2. По названию | 0. Пропустить");
        int subChoice = scanner.nextInt();

        if (subChoice == 1) {
            printMovies(movieService.sortByYearAscending(selection));
        } else if (subChoice == 2) {
            printMovies(movieService.sortByName(selection));
        }
    }

    private void showSortMenu() {
        System.out.println("1. По году (возр.) | 2. По названию | 3. По режиссеру");
        int sortType = scanner.nextInt();
        if (sortType == 1) printMovies(movieService.sortByYearAscending(mainCollection));
        else if (sortType == 2) printMovies(movieService.sortByName(mainCollection));
        else if (sortType == 3) printMovies(movieService.sortByDirector(mainCollection));
    }

    private void printMovies(List<Movie> list) {
        System.out.println("\n--- Результат (" + list.size() + ") ---");
        list.forEach(m -> System.out.println(m + "\n-------------------"));
    }
}