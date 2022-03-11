package by.bsac.individual;

public class Engine extends Wheel{ // двигатель
    private double volume; // объем двигателя
    private int cylinders; // количество цилиндров
    private int km; // сколько км прошёл
    private int KmOil; // кол-во киллометров до замены масла

    Engine(){
        super();
        volume = 0;
        cylinders = 0;
        km = 0;
        KmOil = 0;
    }

    public Engine(double height, String name, String type, double radius, double width, double volume, int cylinders, int km, int kmOil) {
        super(height, name, type, radius, width);
        this.volume = volume;
        this.cylinders = cylinders;
        this.km = km;
        KmOil = kmOil;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getKmOil() {
        return KmOil;
    }

    public void setKmOil(int kmOil) {
        KmOil = kmOil;
    }

    public String Wear(){
        String str;
        if(1000000-getKm() < 1000000){
            str = "Двигатель еще проходит " + km;
        }else{
            str = "Двигателю приходит конец";
        }
        return str;
    }

    @Override
    public String toString() {
        return "Двигатель{" +
                "объем=" + volume +
                ", кол-во цилиндров=" + cylinders +
                ", износ км=" + km +
                ", км до замены масла=" + KmOil +
                '}';
    }
}
