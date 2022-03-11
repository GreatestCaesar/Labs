package by.bsac.lab4.individual.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlBooksDAO implements BooksDAO{
    /** 1. Запрос
     * Выдать по каждому издательству сведения о количестве, общей и средней стоимости проданных книг, сгруппировав их по жанрам */
    private final static String SELECT_QUERY_PUBLISHING = "SELECT publishing_house, genre, COUNT(name) AS amount ,SUM(price) AS proceeds , AVG(price) AS avg_price FROM KNIGA_PRODAGA, KNIGA WHERE KNIGA.id = KNIGA_PRODAGA.id_KNIGA GROUP BY genre, publishing_house;";
    /** 2. Запрос
     * Выдать по покупателю, купившему наибольшее количество книг, его фа-милию и количество купленных книг */
    private final static String SELECT_QUERY_BUYER = "SELECT buyer, COUNT(id_KNIGA) AS amount FROM KNIGA_PRODAGA GROUP BY buyer ORDER BY amount DESC LIMIT 1;";
    /** 3. Запрос
     * Выдать по книге, купленной максимальное количество раз, название и ко-личество проданных экземпляров */
    private final static String SELECT_QUERY_BOOK = "SELECT KNIGA_PRODAGA.id_KNIGA, KNIGA.name, COUNT(KNIGA_PRODAGA.id) AS amount FROM KNIGA_PRODAGA, KNIGA WHERE KNIGA.id = KNIGA_PRODAGA.id_KNIGA GROUP BY KNIGA_PRODAGA.id_KNIGA, KNIGA.name ORDER BY amount DESC LIMIT 1;";
    /** 4. Запрос
     * Выдать список книг, не пользующихся спросом */
    private final static String SELECT_QUERY_BOOKS = "SELECT name, author FROM KNIGA WHERE NOT EXISTS (SELECT * FROM KNIGA_PRODAGA WHERE KNIGA_PRODAGA.id_KNIGA = KNIGA.id);";


    @Override
    public void publishing() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_PUBLISHING);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            System.out.println("# Запрос #\n* Выдать по каждому издательству сведения о количестве, общей и средней стоимости проданных книг, сгруппировав их по жанрам *");
            while (result.next() && result != null) {
                System.out.println("Издательство - " + result.getString(1));
                System.out.println("Жанр - " + result.getString(2));
                System.out.println("Количество - " + result.getInt(3) +
                        " | Выручка - " + result.getInt(4) +
                        " | Средняя цена - " + result.getDouble(5) +
                        "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
    }

    @Override
    public void buyer() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_BUYER);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            System.out.println("# Запрос #\n* Выдать по покупателю, купившему наибольшее количество книг, его фа-милию и количество купленных книг *");
            while (result.next() && result != null) {
                System.out.println("Покупатель - " + result.getString(1) +
                        " | Количество - " + result.getInt(2) +
                        "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
    }

    @Override
    public void book() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_BOOK);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            System.out.println("# Запрос #\n* Выдать по книге, купленной максимальное количество раз, название и ко-личество проданных экземпляров *");
            while (result.next() && result != null) {
                System.out.println("ID - " + result.getInt(1) +
                        " | Название - " + result.getString(2) +
                        " | Количество - " + result.getInt(3) +
                        "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
    }

    @Override
    public void books() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_BOOKS);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            System.out.println("# Запрос #\n* Выдать список книг, не пользующихся спросом *");
            while (result.next() && result != null) {
                System.out.println("Название - " + result.getString(1) +
                        " | Автор - " + result.getString(2) +
                        "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
    }
}
