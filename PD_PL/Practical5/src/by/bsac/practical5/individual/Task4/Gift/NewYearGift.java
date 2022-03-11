package by.bsac.practical5.individual.Task4.Gift;

import by.bsac.practical5.individual.Task4.Exception.NumbersInTheText;
import by.bsac.practical5.individual.Task4.Filling.*;

import java.util.ArrayList;
import java.util.Scanner;

public class NewYearGift {
    private int id;
    private String name;
    private String type;
    private String property;
    private double weight;
    private double sugar;


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NewYearGift(){
        id = 1;
        name = "";
        type = "";
        property = "";
        weight = 0.0;
        sugar = 0.0;
    }

    public NewYearGift(int id, String name, String property, double weight, double sugar){
        this.id = id;
        this.name = name;
        this.type = type;
        this.property = property;
        this.weight = weight;
        this.sugar = sugar;
    }

    public ArrayList CreateS(ArrayList<NewYearGift> gift) throws NumbersInTheText {
        Scanner s = new Scanner(System.in);
        boolean k = true;
        char c;
        int id = 0;
        while(k) {
            System.out.println("1. Добавить конфету\n2. Добавить шоколад\n3. Добавить печенье\n0. Назад");
            c = s.next().charAt(0);
            switch (c) {
                case '1': {
                    String prop="";
                    String name="";
                    id=gift.size()+1;
                    Sweets sweets = new Sweets();
                    sweets.setId(id);
                    sweets.setType("Конфета");
                    s.nextLine();
                    System.out.println("Введите тип конфеты(Например: шоколадкая, леденец): ");
                    prop = s.nextLine();
                    if(numb(prop)==true){
                        throw new NumbersInTheText(prop);
                    }else{
                        sweets.setProperty(prop);
                    }
                    System.out.println("Введите название конфеты: ");
                    name = s.nextLine();
                    if(numb(name)==true){
                        throw new NumbersInTheText(name);
                    }else{
                        sweets.setName(name);
                    }
                    System.out.println("Введите вес конфеты: ");
                    sweets.setWeight(s.nextDouble());
                    s.nextLine();
                    System.out.println("Введите количество сахара(грамм): ");
                    sweets.setSugar(s.nextDouble());
                    s.nextLine();
                    gift.add(sweets);
                    break;
                }
                case '2': {
                    id=gift.size()+1;
                    Chocolate chocolate = new Chocolate();
                    chocolate.setId(id);
                    chocolate.setType("Шоколад");
                    System.out.println("Введите тип шоколада(Например: горький, молочный): ");
                    chocolate.setProperty(s.nextLine());
                    s.nextLine();
                    System.out.println("Введите название шоколада: ");
                    chocolate.setName(s.nextLine());
                    System.out.println("Введите вес шоколада: ");
                    chocolate.setWeight(s.nextDouble());
                    System.out.println("Введите количество сахара(грамм): ");
                    chocolate.setSugar(s.nextDouble());
                    gift.add(chocolate);
                    break;
                }
                case '3': {
                    id=gift.size()+1;
                    Cookie cookie = new Cookie();
                    cookie.setId(id);
                    cookie.setType("Печенье");
                    System.out.println("Введите тип печенья(Например: овсяное, шоколадное): ");
                    cookie.setProperty(s.nextLine());
                    s.nextLine();
                    System.out.println("Введите название печенья: ");
                    cookie.setName(s.nextLine());
                    System.out.println("Введите вес печенья: ");
                    cookie.setWeight(s.nextDouble());
                    System.out.println("Введите количество сахара(грамм): ");
                    cookie.setSugar(s.nextDouble());
                    gift.add(cookie);
                    break;
                }
                case '0': {
                    k = false;
                    break;
                }
                default: {
                    System.err.println("Повторите ввод");
                    break;
                }
            }
        }
        return gift;
    }

    public ArrayList Sort(ArrayList<NewYearGift> gift){
        NewYearGift g = new NewYearGift();
        for(int i=0;i<gift.size();i++){
            for(int j=i+1;j<gift.size();j++){
                if(gift.get(i).getSugar() > gift.get(j).getSugar()){
                    g = gift.get(i);
                    gift.set(i,gift.get(j));
                    gift.set(j,g);
                }
            }
        }
        for(int i=0;i<gift.size();i++){
            gift.get(i).setId(i+1);
        }
        return  gift;
    }

    public boolean numb(String text){
        for(int i=0;i<text.length();i++){
            if(Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
