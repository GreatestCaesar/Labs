package by.bsac.lab4.individual.Timer;

import by.bsac.lab4.individual.Main.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlWatchDAO implements WatchDAO{
    private static final String SELECT_TYPE = "select brand from watch where type=?";
    private static final String SELECT_PRICE = "select * from watch where type='Механические' and price < ?;";
    private static final String SELECT_COUNTRY = "select * from manufacturer where (select locate(?,country) <> 0);";

    @Override
    public ArrayList<Watch> outBrandWhereType(String t) {
        ArrayList<Watch> watches = new ArrayList<>();
        Watch watch = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_TYPE);
            preparedStatement.setString(1, t);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                watch = new Watch();
                watch.setBrand(result.getString(1));
                watches.add(watch);
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
        return watches;
    }

    @Override
    public ArrayList<Watch> outAllWhereTypeAndPrice(double n) {
        ArrayList<Watch> watches = new ArrayList<Watch>();
        Watch watch = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        int b = 0;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_PRICE);
            preparedStatement.setDouble(1, n);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                watch = new Watch();
                watch.setBrand(result.getString(1));
                watch.setModel(result.getString(2));
                watch.setType(result.getString(3));
                watch.setPrice(result.getDouble(4));
                watch.setQuantity(result.getInt(5));
                watch.setRequisites(result.getString(6)); Watch watch1 = new Watch(watch.getBrand(),watch.getModel(),watch.getType(),watch.getPrice(),watch.getQuantity(),watch.getRequisites());
                watches.add(watch1);
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
        return watches;
    }

    @Override
    public ArrayList<Watch> outBrandWhereCountry(String t) {
        ArrayList<Watch> watches = new ArrayList<>();
        Watch watch = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_COUNTRY);
            preparedStatement.setString(1, t);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                watch = new Watch();
                watch.setBrand(result.getString(1));
                watches.add(watch);
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
        return watches;
    }
}
