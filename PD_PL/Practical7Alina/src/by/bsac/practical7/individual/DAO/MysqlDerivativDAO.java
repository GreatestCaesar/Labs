package by.bsac.practical7.individual.DAO;

import by.bsac.practical7.individual.lab.Derivativ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlDerivativDAO implements DerivativDAO {
    private static final String INSERT = "insert into derivativ values(?,?,?);";

    @Override
    public void insertInDB(Derivativ[] derivativs) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            for(int i=0;i<derivativs.length;i++) {
                preparedStatement = conn.prepareStatement(INSERT);
                preparedStatement.setInt(1, derivativs[i].getAmountOfRisk());
                preparedStatement.setInt(2,derivativs[i].getCost());
                preparedStatement.setDouble(3,derivativs[i].getDegree());
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
