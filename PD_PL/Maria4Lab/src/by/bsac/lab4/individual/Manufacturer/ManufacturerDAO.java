package by.bsac.lab4.individual.Manufacturer;

import java.util.ArrayList;

public interface ManufacturerDAO { /** интерфейс для указания, какие методы необходимо иметь в классе, для работы с БД */
    public ArrayList<Manufacturer> outManWhereSum(double l); // вывести производителей, чья общая стоимость часов не превышает заданную
}
