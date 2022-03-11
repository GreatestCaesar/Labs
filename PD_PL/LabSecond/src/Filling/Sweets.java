package Filling;

import Gift.NewYearGift;

public class Sweets extends NewYearGift {
    public Sweets(){
        super();
    }

    Sweets(int id, String name, String type, String property, double weight, double sugar){
        super(id,name,property,weight,sugar);
    }
}
