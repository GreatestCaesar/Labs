package by.bsac.lab4.individual.Timer;

import java.util.ArrayList;

public interface WatchDAO {
    public ArrayList<Watch> outBrandWhereType(String t);      // вывести часы заданного типа
    public ArrayList<Watch> outAllWhereTypeAndPrice(double n);// вывести механические часы чья цена не превышает заданную
    public ArrayList<Watch> outBrandWhereCountry(String t);   // вывести марки часов заданной страны
}
