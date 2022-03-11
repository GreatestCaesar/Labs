package individual;

public class Film {
    private String name;
    private String director;
    private String actors;
    private String year;
    private String county;

    public Film(String name, String director, String actors, String year, String county) {
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.county = county;
        System.out.println("Фильм - " + getName() + " создан" + ", режиссёр:" + getDirector() + ", в ролях: " + getActors() + ", дата выхода - " + getYear() + ", страна - " + getCounty());
    }

    public Film() {
        System.out.println("Фильм создан");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "Фильм - " + getName() + "" + ", режиссёр: " + getDirector() + ", в ролях: " + getActors() + ", дата выхода - " + getYear() + ", страна - " + getCounty();
    }
}
