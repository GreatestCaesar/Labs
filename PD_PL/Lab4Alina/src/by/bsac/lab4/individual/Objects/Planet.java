package by.bsac.lab4.individual.Objects;

public class Planet {
    private String name;
    private int radius;
    private int temperature;
    private String atmosphere;
    private String life;
    private String satellites;

    public Planet(){

    }

    public Planet(String name, int radius, int temperature, String atmosphere, String life, String satellites) {
        this.name = name;
        this.radius = radius;
        this.temperature = temperature;
        this.atmosphere = atmosphere;
        this.life = life;
        this.satellites = satellites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(String atmosphere) {
        this.atmosphere = atmosphere;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getSatellites() {
        return satellites;
    }

    public void setSatellites(String satellites) {
        this.satellites = satellites;
    }

    @Override
    public String toString() {
        return "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nПланета: " +
                "\nназвание - " + name +
                "\nрадиус - " + radius +
                "\nтемпература - " + temperature +
                "\nатмосфера - " + atmosphere +
                "\nжизнь - " + life +
                "\nспутники: " + satellites +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }
}
