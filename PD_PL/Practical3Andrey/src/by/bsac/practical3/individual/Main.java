package by.bsac.practical3.individual;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Window window = new Window("Пластик",1300,60,"Белое",3,3);
        Door door = new Door("Дерево",2000,40,"Коричневый",1,0,true,"Закрыто");
        House house = new House(4,8000,2,8,12);
        door.close("Открыто");
        house.close();
        System.out.println("Окон в доме: " + house.getWindows() + ", дверей: " + house.getDoors());
    }
}
