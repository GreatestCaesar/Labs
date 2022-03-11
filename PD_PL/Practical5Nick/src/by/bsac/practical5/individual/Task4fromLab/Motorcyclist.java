package by.bsac.practical5.individual.Task4fromLab;

import java.util.ArrayList;
import java.util.Scanner;

public class Motorcyclist {
    private String material; // материал
    private double size; // размер
    private double price; // цена
    private double wtight; // вес

    public Motorcyclist() {
        material = "";
        size = 0;
        price = 0;
        wtight = 0;
    }

    public Motorcyclist(String material, double size, double price, double wtight) {
        this.material = material;
        this.size = size;
        this.price = price;
        this.wtight = wtight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWtight() {
        return wtight;
    }

    public void setWtight(double wtight) {
        this.wtight = wtight;
    }

    public ArrayList<by.bsac.practical5.individual.Task4fromLab.Motorcyclist> autoequip(ArrayList<Motorcyclist> m){
        Helmet h = new Helmet("Пластик",20,450,1.1);
        m.add(h);
        Costume c = new Costume("Ткань",27,550,2.5);
        m.add(c);
        Gloves g = new Gloves("Кожа",12,50,0.14);
        m.add(g);
        Boots b = new Boots("Ткань и пластик",44,350,0.8);
        m.add(b);
        return m;
    }

    public ArrayList<Motorcyclist> equip(ArrayList<Motorcyclist> m){
        Scanner s = new Scanner(System.in);
        boolean k=true;
        char t;
        while(k){
            System.out.println("Надеть:\n1. Шлем\t2. Костюм\t3. Перчатки\t4. Сапоги\t0. Назад");
            t = s.next().charAt(0);
            switch (t){
                case '1':{
                    Helmet h = new Helmet();
                    System.out.print("Введите материал: ");
                    h.setMaterial(s.next());
                    System.out.print("Введите размер: ");
                    h.setSize(s.nextDouble());
                    System.out.print("Введите цену: ");
                    h.setPrice(s.nextDouble());
                    System.out.print("Введите вес: ");
                    h.setWtight(s.nextDouble());
                    m.add(h);
                    break;
                }
                case '2':{
                    Costume c = new Costume();
                    System.out.print("Введите материал: ");
                    c.setMaterial(s.next());
                    System.out.print("Введите размер: ");
                    c.setSize(s.nextDouble());
                    s.nextLine();
                    System.out.print("Введите цену: ");
                    c.setPrice(s.nextDouble());
                    s.nextLine();
                    System.out.print("Введите вес: ");
                    c.setWtight(s.nextDouble());
                    s.nextLine();
                    m.add(c);
                    break;
                }
                case '3':{
                    Gloves g = new Gloves();
                    System.out.print("Введите материал: ");
                    g.setMaterial(s.next());
                    System.out.print("Введите размер: ");
                    g.setSize(s.nextDouble());
                    s.nextLine();
                    System.out.print("Введите цену: ");
                    g.setPrice(s.nextDouble());
                    s.nextLine();
                    System.out.print("Введите вес: ");
                    g.setWtight(s.nextDouble());
                    s.nextLine();
                    m.add(g);
                    break;
                }
                case '4':{
                    Boots b = new Boots();
                    System.out.print("Введите материал: ");
                    b.setMaterial(s.next());
                    System.out.print("Введите размер: ");
                    b.setSize(s.nextDouble());
                    s.nextLine();
                    System.out.print("Введите цену: ");
                    b.setPrice(s.nextDouble());
                    s.nextLine();
                    System.out.print("Введите вес: ");
                    b.setWtight(s.nextDouble());
                    s.nextLine();
                    m.add(b);
                    break;
                }
                case '0':{
                    k = false;
                    break;
                }
            }
        }
        return m;
    }

    public ArrayList<Motorcyclist> sort(ArrayList<Motorcyclist> m){
        Motorcyclist g = new Motorcyclist();
        for(int i=0;i<m.size();i++){
            for(int j=i+1;j<m.size();j++){
                if(m.get(i).getWtight() > m.get(j).getWtight()){
                    g = m.get(i);
                    m.set(i,m.get(j));
                    m.set(j,g);
                }
            }
        }
        return m;
    }

    @Override
    public String toString() {
        return "Экипировка{" +
                "материал='" + material + '\'' +
                ", размер=" + size +
                ", цена=" + price +
                ", вес=" + wtight +
                '}';
    }
}
