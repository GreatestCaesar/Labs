package by.bsac.lab4.individual.Manufacturer;

import by.bsac.lab4.individual.Main.MysqlDAOFactory;
import by.bsac.lab4.individual.Timer.Watch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlManufacturerDAO implements ManufacturerDAO{
    public static final String SELECT_QUERY = "select distinct manufacturer.brand from manufacturer join watch where (select sum(watch.price) from watch where (select locate(manufacturer.brand,watch.brand)) <> 0) < ?;";

    @Override
    public ArrayList<Manufacturer> outManWhereSum(double l) {
        ArrayList<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
        Manufacturer manufacturer = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        int b = 0;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY);
            preparedStatement.setDouble(1, l);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                manufacturer = new Manufacturer();
                manufacturer.setBrand(result.getString(1));
                manufacturers.add(manufacturer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
        return manufacturers;
    }
}
