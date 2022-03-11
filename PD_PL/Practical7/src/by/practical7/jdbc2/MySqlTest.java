package by.practical7.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySqlTest {
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "1234";
    public static String DB_NAME = "test";
    private static Connection connection;

    public static void main(String[] args) {
        try {
            createDB(DB_NAME);
            StringBuilder createStudentTable = new StringBuilder().append("create table " + DB_NAME + ".students (").append("id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,").append("personal_id INT(6) NOT NULL,").append("name VARCHAR(30) NOT NULL,").append("course INT(6) NOT NULL,").append("group_number VARCHAR(30) NOT NULL").append(");");
            runStatement(SQLStatemntType.NON_SELECT, createStudentTable.toString());
            StringBuilder sqlQuery = new StringBuilder().append("insert into " + DB_NAME + ".students").append(" (personal_id, name, course, group_number)").append("values (").append("15,").append("'Ivanov Ivan Ivanovich',").append("4,").append("'SP441'").append(");");
            runStatement(SQLStatemntType.NON_SELECT, sqlQuery.toString());
            sqlQuery = new StringBuilder().append("insert into " + DB_NAME + ".students").append(" (personal_id, name, course, group_number)").append("values (").append("16,").append("'Petrov Petr Ivanovich',").append("4,").append("'SP441'").append(");");
            runStatement(SQLStatemntType.NON_SELECT, sqlQuery.toString());
            sqlQuery = new StringBuilder().append("select * from " + DB_NAME + ".students");
            ResultSet rs = runStatement(SQLStatemntType.SELECT, sqlQuery.toString());
            printResultSet(rs);
        } catch (SQLException e) {
            System.out.println("getting exception :" + e);
        } finally {
            closeConnection();
        }
    }

    /**
     * @param dbName
     * создать базу данных с таким названием
     * @throws SQLException
     */
    public static void createDB(String dbName) throws SQLException {
        dropDB(dbName);
        runStatement(SQLStatemntType.NON_SELECT, "CREATE DATABASE " + dbName);
    }

    /**
     * @param dbName
     * удалить базу данных
     * @throws SQLException
     */
    public static void dropDB(String dbName) throws SQLException {
        runStatement(SQLStatemntType.NON_SELECT, "DROP DATABASE IF EXISTS " + dbName);
    }

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

    public static Connection getConnection() {
        if (connection == null) {
            connection = createConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Сonnection close error: " + e);
            }
        }
    }

    /**
     * @param type
     * определяет возвращается ли ResultSet( select или
     * non-select(insert, update, delete, create) запрос
     * @param sqlQuery
     * запрос для выполнение
     * @return
     * @throws SQLException
     */
    public static ResultSet runStatement(SQLStatemntType type, String sqlQuery) throws SQLException {
        boolean executed = false;
        ResultSet rs = null;
        // получаем connection к базе данны
        Statement statement = getConnection().createStatement();
        switch (type) {
            case NON_SELECT:
        // если запрос insert, update, delete, create, то необходимо
        // выполнить executeUpdate
                statement.executeUpdate(sqlQuery);
                break;
            case SELECT:
        // если запрос select - выполняем executeQuery, который возвращает
        // ResultSet
                rs = statement.executeQuery(sqlQuery);
                break;
            default:
        // для любого типа запроса
                statement.execute(sqlQuery);
                break;
        }
        executed = true;
        System.out.println("SQL query to execute = [" + sqlQuery + "] result:" + executed);
        return rs;
    }

    /**
     * Выводит результат запроса в консоль
     *
     * @param resultSetToPrint
     * результат запроса, который необходимо вывести на консоль
     */
    public static void printResultSet(ResultSet resultSetToPrint) {
        try {
            ResultSetMetaData rsmd = resultSetToPrint.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSetToPrint.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1)
                        System.out.print(" | ");
                    System.out.print(resultSetToPrint.getString(i));
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("Error printing resultSet [" + e + "]");
        }
    }
}