package individual;

public class Actor {
    private String second_name;
    private String first_name;
    private String patronymic;
    private String DOB;
    private int numOfFilm;

    public Actor(String second_name, String  first_name, String  patronymic, String DOB, int numOfFilm) {
        this.second_name = second_name;
        this.first_name = first_name;
        this.patronymic = patronymic;
        this.DOB = DOB;
        this.numOfFilm = numOfFilm;
        System.out.println("Актёр " + getSecond_name() + " " + getFirst_name() + " " + getPatronymic() + " " + " создан, дата рождения - " + getDOB() +", количество фильмов - " + getNumOfFilm());
    }

    public Actor() {
        System.out.println("Актёр создан");
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getNumOfFilm() {
        return numOfFilm;
    }

    public void setNumOfFilm(int numOfFilm) {
        this.numOfFilm = numOfFilm;
    }

    @Override
    public String toString() {
        return "Актёр - " + "'" + second_name + " " + first_name + " " + patronymic + '\'' + ", дата рождения - '" + DOB + '\'' + ", количество фильмов - '" + numOfFilm + '\'';
    }
}