package by.practical7.example.firstconn;

import java.sql.*;

public class Main {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false& requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    public static void main(String[] args)
    {
        try {
            dropDatabase();
            //updateDbUserTable();
            //deleteDbUserTable();
            //selectDbUserTable();
            //insertDbUserTable();
            //createDbUserTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private static void dropDatabase() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String dropDatabase = "DROP DATABASE IF EXISTS test";
        //String insertTableSQL = "INSERT INTO DBUSER" + "(USER_ID, USERNAME, CREATED_BY) " + "VALUES" + "(1,'mkyong','system');";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            // выполнить SQL запрос
            statement.execute(dropDatabase);
            //statement.executeUpdate(insertTableSQL);
            System.out.println("Database dropped!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void createDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String createTableSQL = "CREATE TABLE DBUSER(" + "USER_ID INTEGER(5) NOT NULL, " + "USERNAME VARCHAR(20) NOT NULL, " + "CREATED_BY VARCHAR(20) NOT NULL, " + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) " + ")";
        //String insertTableSQL = "INSERT INTO DBUSER" + "(USER_ID, USERNAME, CREATED_BY) " + "VALUES" + "(1,'mkyong','system');";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            // выполнить SQL запрос
            statement.execute(createTableSQL);
            //statement.executeUpdate(insertTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void insertDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String insertTableSQL = "INSERT INTO DBUSER" + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES" + "(1,'mkyong','system','18.02.2021')";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            // выполнить SQL запрос
            statement.executeUpdate(insertTableSQL);
            System.out.println("Data entered into \"dbuser\"!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void selectDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String selectTableSQL = "SELECT USER_ID, USERNAME from DBUSER;";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);
            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String userid = rs.getString("USER_ID");
                String username = rs.getString("USERNAME");
                System.out.println("userid : " + userid);
                System.out.println("username : " + username);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void deleteDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String deleteTableSQL = "DELETE FROM DBUSER WHERE USER_ID = 1;";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            // выполняем запрос delete SQL
            statement.execute(deleteTableSQL);
            System.out.println("Record is deleted from DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void updateDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String updateTableSQL = "UPDATE DBUSER SET USERNAME = 'mkyong_new' WHERE USER_ID = 1;";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            // выполняем запрос update SQL
            statement.execute(updateTableSQL);
            System.out.println("Record is updated to DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
