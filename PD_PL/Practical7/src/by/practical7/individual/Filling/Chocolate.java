package by.practical7.individual.Filling;


import by.practical7.individual.Gift.NewYearGift;

public class Chocolate extends NewYearGift {
    public Chocolate(){
        super();
    }

    public Chocolate(int id, String name, String type, String property, double weight, double sugar){
        super(id,name,property,weight,sugar);
    }
}
