package by.bsac.lab4.individual.Tools;

import by.bsac.lab4.individual.DAO.MysqlDAOFactoryBY;
import by.bsac.lab4.individual.DAO.MysqlDAOFactoryRU;

import java.sql.*;
import java.util.Properties;

public class Create {       /** Класс такой же как и MysqlDAOFactory, но служит для ознакомления, чтобы не заполнять БД через консоль, а просто берет данные из файла и делает всё с помощью Java */
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "1234";
    public static String DB_NAME = "mysql";
    public static Connection connection;
    public static PreparedStatement preparedStatement = null;
    private static final String DROP1 = "drop database if exists ru;";
    private static final String DROP2 = "drop database if exists byy;";
    private static final String CREATE_DATABASE1 = "create database ru";
    private static final String CREATE_DATABASE2 = "create database byy";
    private static final String CREATE_TABLE_RU = "create table ru(word_ru varchar(500),word_by varchar(500));";
    private static final String CREATE_TABLE_BY = "create table byy(word_by varchar(500),word_ru varchar(500));";

    public static Connection createConnection() {
        String url = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Properties prop = new Properties();
        prop.put("user", DB_USER);
        prop.put("password", DB_PASSWORD);
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, prop);
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        }
        return connection;
    }

    public static void create() throws SQLException {
        connection = createConnection();
        Statement statement = createConnection().createStatement();
        statement.execute(DROP1);
        statement.execute(DROP2);
        statement.execute(CREATE_DATABASE1);
        statement.execute(CREATE_DATABASE2);
    }

    public static void createTables(){
        try {
            connection = MysqlDAOFactoryRU.createConnection();
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE_RU);
            connection = MysqlDAOFactoryBY.createConnection();
            statement = connection.createStatement();
            statement.execute(CREATE_TABLE_BY);
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
