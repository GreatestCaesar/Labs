package by.bsac.lab4.individual.Main;

import by.bsac.lab4.individual.Manufacturer.Manufacturer;
import by.bsac.lab4.individual.Manufacturer.ManufacturerDAO;
import by.bsac.lab4.individual.Manufacturer.MysqlManufacturerDAO;
import by.bsac.lab4.individual.Timer.MysqlWatchDAO;
import by.bsac.lab4.individual.Timer.WatchDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlDAOFactory extends DAOFactory {
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "1234";
    public static String DB_NAME = "watch_shop";
    public static Connection connection;
    public static PreparedStatement preparedStatement = null;

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
    public ManufacturerDAO getManufacturerDAO() {
        return new MysqlManufacturerDAO();
    }

    @Override
    public WatchDAO getWatchDAO() {
        return new MysqlWatchDAO();
    }
}
