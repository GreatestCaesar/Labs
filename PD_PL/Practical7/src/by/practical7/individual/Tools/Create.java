package by.practical7.individual.Tools;

import by.practical7.individual.Menu.MysqlDAOFactory;

import java.sql.*;
import java.util.Properties;

public class Create {
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "1234";
    public static String DB_NAME = "mysql";
    public static Connection connection;
    public static PreparedStatement preparedStatement = null;
    private static final String DROP = "drop database if exists present;";
    private static final String CREATE_DATABASE = "create database present";
    private static final String CREATE_TABLE_PRESENT = "create table present(id int auto_increment primary key,name varchar(200),type varchar(200),property varchar(200),weight double,sugar double)";

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
        Connection connection = createConnection();
        Statement statement = createConnection().createStatement();
        statement.execute(DROP);
        statement = createConnection().createStatement();
        statement.execute(CREATE_DATABASE);
    }

    public static void createTables(){
        try {
            connection = MysqlDAOFactory.createConnection();
            preparedStatement = connection.prepareStatement(CREATE_TABLE_PRESENT);
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
