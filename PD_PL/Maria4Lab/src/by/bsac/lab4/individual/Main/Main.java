package by.bsac.lab4.individual.Main;

import by.bsac.lab4.individual.Manufacturer.DataForManufacturer;
import by.bsac.lab4.individual.Manufacturer.Manufacturer;
import by.bsac.lab4.individual.Manufacturer.ManufacturerDAO;
import by.bsac.lab4.individual.Tools.Create;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * На этапе запуска необходимо выполнить несколько задач
 * 1. Подключить драйвер (см. Методичка)
 * 2. Наличие MySQL ОБЯЗАТЕЛЬНО
 * 3. Создать и заполнить БД и таблицы, т.к. без БД драйвер не сможет установить соединение с MySQL
 * 4. Запуск программы
 * */

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        double price;

        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);  /** Создание экземпляра DAOFactory, для хранения соединения с определённой БД */
        ManufacturerDAO ManufacturerDAO = mysqlFactory.getManufacturerDAO();    /** Экземпляр класса, с помощью которого будет проводиться работа с таблицей */

        ArrayList<Manufacturer> manufacturers; /** Список для хранения данных из таблицы */

        Create.create();    /** класс для создания БД, чтобы продемонстрировать работу Java и MySQL без ввода данных непосредственно из консоли */
        Create.createTables();  /** Создание таблиц на основе данных из файла */
        DataForManufacturer.filling(); /** Заполнение таблицы данными */

        System.out.println("Введите сумму, котороую не должна превышать общая сумма часов всех производителей: ");
        price = scanner.nextDouble();
        manufacturers = ManufacturerDAO.outManWhereSum(price); /** Взаимодействие с БД при помощи Java */
        for(Manufacturer m : manufacturers){
            System.out.println(m);
        }
    }
}
