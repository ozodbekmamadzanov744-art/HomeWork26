import java.util.List;
public class Movie {
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;


    public Movie(String name, int year, String description, Director director, List<Cast> cast) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.cast = cast;
    }

    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return String.format("Фильм: %s (%d)\nОписание: %s\nРежиссер: %s\nАктеры: %s\n",
                name, year, description, director, cast);
    }
}
