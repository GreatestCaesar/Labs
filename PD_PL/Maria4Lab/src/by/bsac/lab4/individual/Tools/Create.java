package by.bsac.lab4.individual.Tools;

import by.bsac.lab4.individual.Main.MysqlDAOFactory;

import java.sql.*;
import java.util.Properties;

public class Create {       /** Класс такой же как и MysqlDAOFactory, но служит для ознакомления, чтобы не заполнять БД через консоль, а просто берет данные из файла и делает всё с помощью Java */
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "masha1234567";
    public static String DB_NAME = "mysql";
    public static Connection connection;
    public static PreparedStatement preparedStatement = null;
    private static final String DROP = "drop database if exists watch_shop;";
    private static final String CREATE_DATABASE = "create database watch_shop";
    private static final String CREATE_TABLE_MANUF = "create table manufacturer(brand varchar(500) not null,country varchar(500));";

    public static Connection createConnection() {
        String url = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        System.out.println("Connection Url:" + url);
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
        statement.execute(DROP);
        statement = createConnection().createStatement();
        statement.execute(CREATE_DATABASE);
    }

    public static void createTables(){
        try {
            connection = MysqlDAOFactory.createConnection();
            preparedStatement = connection.prepareStatement(CREATE_TABLE_MANUF);
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
