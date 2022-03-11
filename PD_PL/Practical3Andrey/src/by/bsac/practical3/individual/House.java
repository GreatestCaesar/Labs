package by.bsac.practical3.individual;

import java.util.ArrayList;
import java.util.Scanner;

public class House extends Door{
    public int room; // кол-во комнат
    public double height; // высота
    public int floor; // кол-во этажей
    public int windows; // кол-во окон
    public int doors; // кол-во дверей

    public House(String material, double height, double width, String color, int num, int glass, boolean lock, String mode, int room, double height1, int floor, int windows, int doors) {
        super(material, height, width, color, num, glass, lock, mode);
        this.room = room;
        this.height = height1;
        this.floor = floor;
        this.windows = windows;
        this.doors = doors;
    }

    public House(int room, double height, int floor, int windows, int doors) {
        this.room = room;
        this.height = height;
        this.floor = floor;
        this.windows = windows;
        this.doors = doors;
    }

    public House() {
        super();
        room = 0;
        height = 0;
        floor = 0;
        windows = 0;
        doors = 0;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    public void close() {
        if(super.getMode().equals("Закрыто")){
            System.out.println("Дом заперт");
        }else{
            System.out.println("Дом открыт");
        }
    }

    @Override
    public String toString() {
        return "Дом{" +
                "кол-во комнта=" + room +
                ", высота=" + height +
                ", кол-во этажей=" + floor +
                '}';
    }
}
