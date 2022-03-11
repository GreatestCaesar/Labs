package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlDAOFactory extends DAOFactory {
    /* The driver-class.
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    *//** The username for database-operations. *//*
    public static final String USER = "root";
    *//** The password for database-operations. *//*
    public static final String PASS = "1234";
    *//** The url to database. *//*
    private static final String DBURL = "jdbc:mysql://localhost:3306/test";*/
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "1234";
    public static String DB_NAME = "test1";
    private static Connection connection;

    /**
     * Method to create a Connection on the mysql-database.
     *
     * @return the Connection.
     */
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
    @Override
    public StudentDAO getStudentDAO() {
        return new MysqlStudentDAO();
    }
}
