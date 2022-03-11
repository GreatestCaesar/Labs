package sandbox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ex {
    private static final String CREATE_DATABASE = "create database lol";
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        conn = Connect.createConnection();
        preparedStatement = conn.prepareStatement(CREATE_DATABASE);
        preparedStatement.execute();
    }
}
