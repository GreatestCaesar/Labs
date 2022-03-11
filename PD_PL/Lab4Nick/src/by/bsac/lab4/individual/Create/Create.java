package by.bsac.lab4.individual.Create;


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
    private static final String DROP = "drop database if exists store;";
    private static final String CREATE_DATABASE = "create database store";
    private static final String CREATE_TABLE_KNIGA = "CREATE  TABLE  KNIGA (id  int(5) PRIMARY KEY,name VARCHAR(25) NOT NULL, author VARCHAR(20), price double CHECK(price>1), publishing_house  VARCHAR(15),  genre VARCHAR(15));";
    private static final String CREATE_TABLE_KNIGA_PRODAGA = "CREATE  TABLE  KNIGA_PRODAGA (id  int(10) PRIMARY KEY,id_KNIGA int(5) NOT NULL, seller VARCHAR(20), buyer VARCHAR(20), date  Date);";

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
            preparedStatement = connection.prepareStatement(CREATE_TABLE_KNIGA);
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(CREATE_TABLE_KNIGA_PRODAGA);
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
