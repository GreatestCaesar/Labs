package by.bsac.lab4.individual.Objects;

public class Galaxy {
    private String name;
    private String planets;

    public Galaxy(){

    }

    public Galaxy(String name, String planets) {
        this.name = name;
        this.planets = planets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanets() {
        return planets;
    }

    public void setPlanets(String planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "Галактика: " +
                "\nназвание - " + name +
                "\nпланеты: " + planets;
    }
}
