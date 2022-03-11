package by.bsac.lab4.individual.Create;
;

import by.bsac.lab4.individual.DAO.MysqlDAOFactory;

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
    private static final String DROP = "drop database if exists spacee;";
    private static final String CREATE_DATABASE = "create database spacee";
    private static final String CREATE_TABLE_PLANETS = "create table planets(name varchar(100),radius int,temperature int,atmosphere varchar(20),life varchar(20),satellites varchar(100));";
    private static final String CREATE_TABLE_SATELLITES = "create table satellites(name varchar(100),radius int,distance int);";
    private static final String CREATE_TABLE_GALAXY = "create table galaxy(name varchar(100),planet varchar(100));";

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
        statement.execute(DROP);
        statement = createConnection().createStatement();
        statement.execute(CREATE_DATABASE);
    }

    public static void createTables(){
        try {
            connection = MysqlDAOFactory.createConnection();
            preparedStatement = connection.prepareStatement(CREATE_TABLE_PLANETS);
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(CREATE_TABLE_SATELLITES);
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(CREATE_TABLE_GALAXY);
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
