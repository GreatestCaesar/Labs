package by.bsac.practical3.individual;

public class Door extends Window{
    private boolean lock; // замок
    private String mode; // режим(закрыто/открыто)

    public Door(String material, double height, double width, String color, int num, int glass, boolean lock, String mode) {
        super(material, height, width, color, num, glass);
        this.lock = lock;
        this.mode = mode;
    }

    public Door(boolean lock, String mode) {
        this.lock = lock;
        this.mode = mode;
    }

    public Door() {
        super();
        lock = true;
        mode = "";
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void close(String s){
        if(lock){
            switch (s){
                case "Закрыть":{
                    mode = "Закрыто";
                    break;
                }
                case "Открыть":{
                    mode = "Открыто";
                    break;
                }
            }
        }else{
            System.out.println("В двери нет замка");
        }
    }

    @Override
    public String toString() {
        return "Дверь{" +
                "наличие замка=" + lock +
                ", режим'" + mode + '\'' +
                '}';
    }
}
