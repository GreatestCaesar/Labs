package by.bsac.lab4.individual.Main;

import by.bsac.lab4.individual.Create.Create;
import by.bsac.lab4.individual.Create.DataForStore;
import by.bsac.lab4.individual.DAO.BooksDAO;
import by.bsac.lab4.individual.DAO.DAOFactory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Create.create();
        Create.createTables();
        DataForStore.filling();


        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);  /** Создание экземпляра DAOFactory, для хранения соединения с определённой БД */
        BooksDAO booksDAO = mysqlFactory.getBooksDAO();    /** Экземпляр класса, с помощью которого будет проводиться работа с таблицей */

        booksDAO.publishing();
        System.out.println("\n\n");
        booksDAO.buyer();
        System.out.println("\n\n");
        booksDAO.book();
        System.out.println("\n\n");
        booksDAO.books();
    }
}
