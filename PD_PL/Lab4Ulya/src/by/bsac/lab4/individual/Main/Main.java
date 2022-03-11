package by.bsac.lab4.individual.Main;

import by.bsac.lab4.individual.Manufacturer.DataForManufacturer;
import by.bsac.lab4.individual.Manufacturer.Manufacturer;
import by.bsac.lab4.individual.Manufacturer.ManufacturerDAO;
import by.bsac.lab4.individual.Timer.DataForWatch;
import by.bsac.lab4.individual.Timer.Watch;
import by.bsac.lab4.individual.Timer.WatchDAO;
import by.bsac.lab4.individual.Tools.Create;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String type;
        double price;
        String country;
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        WatchDAO WatchDAO = mysqlFactory.getWatchDAO();
        ManufacturerDAO ManufacturerDAO = mysqlFactory.getManufacturerDAO();
        ArrayList<Watch> watches;
        ArrayList<Manufacturer> manufacturers;

        Create.create();
        Create.createTables();
        DataForWatch.filling();
        DataForManufacturer.filling();

        System.out.println("Введите тип часов (Механические/Кварцевые): ");
        type = scanner.nextLine();
        watches = WatchDAO.outBrandWhereType(type);
        for(Watch w : watches){
            System.out.println(w);
        }

        System.out.println("Введите цену, которую не должны превышать часы: ");
        price = scanner.nextDouble();
        watches = WatchDAO.outAllWhereTypeAndPrice(price);
        for(Watch w : watches){
            System.out.println(w.getBrand() + " " + w.getModel() + " "  + w.getType() + " " + w.getPrice() + " " + w.getQuantity() + " " + w.getRequisites());
        }

        System.out.println("Введите страну, из которой должны быть часы: ");
        scanner.nextLine();
        country = scanner.nextLine();
        watches = WatchDAO.outBrandWhereCountry(country);
        for(Watch w : watches){
            System.out.println(w);
        }

        System.out.println("Введите сумму, котороую не должна превышать общая сумма часов всех производителей: ");
        price = scanner.nextDouble();
        manufacturers = ManufacturerDAO.outManWhereSum(price);
        for(Manufacturer m : manufacturers){
            System.out.println(m);
        }
    }
}
