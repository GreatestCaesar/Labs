package by.bsac.lab4.individual.Manufacturer;

import by.bsac.lab4.individual.Main.MysqlDAOFactory;
import by.bsac.lab4.individual.Tools.DatafromFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataForManufacturer {
    private static final String INSERT = "insert into manufacturer (brand,country) values (?,?);";
    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    public static void filling() throws SQLException {
        String[] manufacturer;
        String[] manufacture;
        String temp = "";
        String txt = DatafromFile.readFile("src/by/bsac/lab4/individual/Manufacturer/","manufacturer.txt"); // указать путь к файлу manuf...
        conn = MysqlDAOFactory.createConnection();
        preparedStatement = conn.prepareStatement(INSERT);
        manufacturer = txt.split("\n");
        for(int i=0;i< manufacturer.length;i++){
            temp = manufacturer[i];
            manufacture = temp.split("\\.");
            preparedStatement.setString(1, manufacture[0]);
            preparedStatement.setString(2, manufacture[1]);
            preparedStatement.execute();
        }
    }
}
