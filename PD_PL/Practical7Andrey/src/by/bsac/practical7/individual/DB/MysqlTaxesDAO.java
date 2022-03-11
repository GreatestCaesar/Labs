package by.bsac.practical7.individual.DB;

import by.bsac.practical7.individual.Main.Taxes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlTaxesDAO implements TaxesDAO{
    private static final String INSERT = "insert into taxes values(?,?,?);";

    @Override
    public void insertInDB(Taxes[] t) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            for(int i=0;i<t.length;i++) {
                preparedStatement = conn.prepareStatement(INSERT);
                switch (String.valueOf(t[i].getClass()).substring(String.valueOf(t[i].getClass()).lastIndexOf('.')+1)){
                    case "PlaceOfWork":{
                        preparedStatement.setString(1, "PlaceOfWork");
                        break;
                    }
                    case "Privileges":{
                        preparedStatement.setString(1, "Privileges");
                        break;
                    }
                    case "Rewards":{
                        preparedStatement.setString(1, "Rewards");
                        break;
                    }
                }
                preparedStatement.setDouble(2, t[i].getTaxrate());
                preparedStatement.setDouble(3, t[i].getTaxrate());
                preparedStatement.execute();
            }
            System.out.println("Данные сохранены!");
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
            System.out.println();
        }
    }
}
