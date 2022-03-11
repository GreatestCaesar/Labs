package by.bsac.practical5.individual.Task4.Filling;

import by.bsac.practical5.individual.Task4.Gift.NewYearGift;

public class Sweets extends NewYearGift {
    public Sweets(){
        super();
    }

    Sweets(int id, String name, String type, String property, double weight, double sugar){
        super(id,name,property,weight,sugar);
    }
}
