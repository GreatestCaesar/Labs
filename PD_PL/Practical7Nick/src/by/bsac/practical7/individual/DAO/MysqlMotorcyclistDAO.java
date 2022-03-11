package by.bsac.practical7.individual.DAO;

import by.bsac.practical7.individual.Main.Motorcyclist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlMotorcyclistDAO implements MotorcyclistDAO {
    private static final String INSERT = "insert into equipment values(?,?,?,?,?);";

    @Override
    public void insertInDB(ArrayList<Motorcyclist> mot) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            for(int i=0;i<mot.size();i++){
                preparedStatement = conn.prepareStatement(INSERT);
                switch (String.valueOf(mot.get(i).getClass()).substring(String.valueOf(mot.get(i).getClass()).lastIndexOf('.')+1)){
                    case "Boots":{
                        preparedStatement.setString(1, "Сапоги");
                        preparedStatement.setString(2, mot.get(i).getMaterial());
                        preparedStatement.setDouble(3, mot.get(i).getSize());
                        preparedStatement.setDouble(4, mot.get(i).getPrice());
                        preparedStatement.setDouble(5, mot.get(i).getWtight());
                        preparedStatement.execute();
                        break;
                    }
                    case "Costume":{
                        preparedStatement.setString(1, "Костюм");
                        preparedStatement.setString(2, mot.get(i).getMaterial());
                        preparedStatement.setDouble(3, mot.get(i).getSize());
                        preparedStatement.setDouble(4, mot.get(i).getPrice());
                        preparedStatement.setDouble(5, mot.get(i).getWtight());
                        preparedStatement.execute();
                        break;
                    }
                    case "Gloves":{
                        preparedStatement.setString(1, "Перчатки");
                        preparedStatement.setString(2, mot.get(i).getMaterial());
                        preparedStatement.setDouble(3, mot.get(i).getSize());
                        preparedStatement.setDouble(4, mot.get(i).getPrice());
                        preparedStatement.setDouble(5, mot.get(i).getWtight());
                        preparedStatement.execute();
                        break;
                    }
                    case "Helmet":{
                        preparedStatement.setString(1, "Шлем");
                        preparedStatement.setString(2, mot.get(i).getMaterial());
                        preparedStatement.setDouble(3, mot.get(i).getSize());
                        preparedStatement.setDouble(4, mot.get(i).getPrice());
                        preparedStatement.setDouble(5, mot.get(i).getWtight());
                        preparedStatement.execute();
                        break;
                    }
                }
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
