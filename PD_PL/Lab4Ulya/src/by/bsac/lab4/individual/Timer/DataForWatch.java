package by.bsac.lab4.individual.Timer;

import by.bsac.lab4.individual.Main.MysqlDAOFactory;
import by.bsac.lab4.individual.Tools.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataForWatch {
    private static final String INSERT = "insert into watch (brand,model,type,price,quantity,requisites) values (?,?,?,?,?,?);";
    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    public static void filling() throws SQLException {
        String[] watches;
        String[] watch;
        String temp = "";
        String txt = DatafromFile.readFile("src/by/bsac/lab4/individual/Timer/","watch.txt"); // указать путь к файлу watch.txt
        conn = MysqlDAOFactory.createConnection();
        preparedStatement = conn.prepareStatement(INSERT);
        watches = txt.split("\n");
        for(int i=0;i< watches.length;i++){
            temp = watches[i];
            watch = temp.split("_");
            preparedStatement.setString(1, watch[0]);
            preparedStatement.setString(2, watch[1]);
            preparedStatement.setString(3, watch[2]);
            preparedStatement.setDouble(4, Double.parseDouble(watch[3]));
            preparedStatement.setInt(5, Integer.parseInt(watch[4]));
            preparedStatement.setString(6, watch[5]);
            preparedStatement.execute();
        }
    }
}
