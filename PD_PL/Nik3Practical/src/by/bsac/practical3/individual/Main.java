package by.bsac.practical3.individual;

public class Main {
    public static void main(String[] args){
        Computer comp = new Computer("SC-2340",23.5,256,100,"Gesj",245,"внутренний",8,3.7,4,2.5,1000,8,12,"Виндафс","Nvidia Geforce GTX",true);
        System.out.println(comp);
        comp.on_off(2);
        System.out.println("Объем винчестера: " + comp.win());
        comp.virus();
    }
}
