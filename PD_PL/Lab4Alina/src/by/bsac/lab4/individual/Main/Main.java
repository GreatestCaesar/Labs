package by.bsac.lab4.individual.Main;

import by.bsac.lab4.individual.Create.Create;
import by.bsac.lab4.individual.Create.DataForSpace;
import by.bsac.lab4.individual.Create.DatafromFile;
import by.bsac.lab4.individual.DAO.DAOFactory;
import by.bsac.lab4.individual.DAO.SpaceDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Create.create();
        Create.createTables();
        DataForSpace.filling();

        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);  /** Создание экземпляра DAOFactory, для хранения соединения с определённой БД */
        SpaceDAO spaceDAO = mysqlFactory.getSpaceDAO();    /** Экземпляр класса, с помощью которого будет проводиться работа с таблицей */

        System.out.println("Введите название галактики, в которой необходимо искать: ");
        String galaxy = scanner.nextLine();
        spaceDAO.findLife(galaxy);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        spaceDAO.countSattelites();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Введите какое количество должно быть у планеты: ");
        int x = scanner.nextInt();
        spaceDAO.haveSattelites(x);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        spaceDAO.radius();
    }
}
