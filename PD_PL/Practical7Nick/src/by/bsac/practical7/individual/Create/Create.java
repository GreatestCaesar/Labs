package by.bsac.practical7.individual.Create;

import by.bsac.practical7.individual.DAO.MysqlDAOFactory;

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
    private static final String DROP = "drop database if exists motorcyclist;";
    private static final String CREATE_DATABASE = "create database motorcyclist";
    private static final String CREATE_TABLE_PRESENT = "create table equipment(type varchar(500),material varchar(500),size double,price double,weight double)";

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
