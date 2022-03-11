package individual;

public class Director {
    private String second_name;
    private String first_name;
    private String patronymic;
    private String DOB;

    public Director(String second_name, String first_name, String patronymic, String DOB) {
        this.second_name = second_name;
        this.first_name = first_name;
        this.patronymic = patronymic;
        this.DOB = DOB;
        System.out.println("Режиссёр " + getSecond_name() + " " + getFirst_name() + " " + getPatronymic() + " " + " создан, дата рождения - " + getDOB());
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

    @Override
    public String toString() {
        return "Режиссёр - " + "'" + second_name + " " + first_name + " " + patronymic + '\'' + ", дата рождения - '" + DOB + '\'' + '}';
    }
}