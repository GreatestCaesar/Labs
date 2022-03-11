package by.bsac.practical.individual.planes;

import by.bsac.practical.individual.cargo.CargoPlane;
import by.bsac.practical.individual.main.MysqlDAOFactory;
import by.bsac.practical.individual.passenger.PassengerPlane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlPlaneDAO implements PlaneDAO{
    private static final String INSERT = "insert into planes values(?,?,?,?,?);";

    @Override
    public void insert(Plane[] p) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            for(int i=0;i<p.length;i++){
                switch (p[i].getClass().getSimpleName()){
                    case "PassengerPlane":{
                        preparedStatement = conn.prepareStatement(INSERT);
                        PassengerPlane pass = (PassengerPlane) p[i];
                        preparedStatement.setString(1,"Пассажирский самолет");
                        preparedStatement.setDouble(2,pass.range);
                        preparedStatement.setDouble(3,pass.getFuelCons());
                        preparedStatement.setDouble(4,pass.getCapacity());
                        preparedStatement.setDouble(5,0.0);
                        preparedStatement.execute();
                        break;
                    }
                    case "CargoPlane":{
                        preparedStatement = conn.prepareStatement(INSERT);
                        CargoPlane cargoPlane = (CargoPlane) p[i];
                        preparedStatement.setString(1,"Грузовой самолет");
                        preparedStatement.setDouble(2,cargoPlane.getRange());
                        preparedStatement.setDouble(3,cargoPlane.getFuelCons());
                        preparedStatement.setDouble(4,0.0);
                        preparedStatement.setDouble(5,cargoPlane.getLiftCap());
                        preparedStatement.execute();
                        break;
                    }
                    case "Plane":{
                        preparedStatement = conn.prepareStatement(INSERT);
                        Plane plane = (Plane) p[i];
                        preparedStatement.setString(1,"Самолет");
                        preparedStatement.setDouble(2,plane.getRange());
                        preparedStatement.setDouble(3,plane.getFuelCons());
                        preparedStatement.setDouble(4,0.0);
                        preparedStatement.setDouble(5,0.0);
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
