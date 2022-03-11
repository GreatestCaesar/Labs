package by.practical7.individual.Gift;

import by.practical7.individual.Menu.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlGiftDAO implements GiftDAO{
    private static final String INSERT = "insert into present values(?,?,?,?,?,?);";

    @Override
    public void insertInDB(ArrayList<NewYearGift> g) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            for(int i=0;i<g.size();i++) {
                preparedStatement = conn.prepareStatement(INSERT);
                preparedStatement.setInt(1, g.get(i).getId());
                preparedStatement.setString(2,g.get(i).getName());
                preparedStatement.setString(3,g.get(i).getType());
                preparedStatement.setString(4,g.get(i).getProperty());
                preparedStatement.setDouble(5,g.get(i).getWeight());
                preparedStatement.setDouble(6,g.get(i).getSugar());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
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
    }
}
