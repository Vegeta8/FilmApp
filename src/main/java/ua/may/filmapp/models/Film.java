package ua.may.filmapp.models;

// Клас/модель об'єкта який використовується на веб сторінці і в базі даних
public class Film {
    private int id;
    private String name;
    private String genre;
    private int year;
    private String director;
    private String mainActor;

    public Film() {

    }

    public Film(int id, String name, String genre, int year, String director, String mainActor) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.director = director;
        this.mainActor = mainActor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }
}
