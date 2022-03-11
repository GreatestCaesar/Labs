package by.bsac.practical7.individual.Create;

import by.bsac.practical7.individual.Lab.CargoPlane;
import by.bsac.practical7.individual.Lab.PassengerPlane;
import by.bsac.practical7.individual.Lab.Plane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataForPlanes {
    private static final String INSERT1 = "insert into planes (type,distance,fuelCons) values (?,?,?);";
    private static final String INSERT2 = "insert into planes (type,distance,fuelCons,liftCap) values (?,?,?,?);"; /** Запрос для MySQL, где '?' служит как указателем, что необходимо вставить на данное место
                                                                                                    зависит от данных, которые будут изъяты из файла*/
    private static final String INSERT3 = "insert into planes (type,distance,fuelCons,capacity) values (?,?,?,?);";
    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    public static void filling(Object p) throws SQLException {
        conn = MysqlDAOFactory.createConnection();  /** установление соединения с БД */
        switch (String.valueOf(p.getClass())){
            case "class by.bsac.practical7.individual.Lab.Plane":{
                preparedStatement = conn.prepareStatement(INSERT1);
                preparedStatement.setString(1,"Самолёт");
                preparedStatement.setDouble(2,((Plane) p).getRange());
                preparedStatement.setDouble(3,((Plane) p).getFuelCons());
                preparedStatement.execute();
                break;
            }
            case "class by.bsac.practical7.individual.Lab.CargoPlane":{
                preparedStatement = conn.prepareStatement(INSERT2);
                preparedStatement.setString(1,"Грузовой самолет");
                preparedStatement.setDouble(2,((CargoPlane) p).getRange());
                preparedStatement.setDouble(3,((CargoPlane) p).getFuelCons());
                preparedStatement.setDouble(4,((CargoPlane) p).getLiftCap());
                preparedStatement.execute();
                break;
            }
            case "class by.bsac.practical7.individual.Lab.PassengerPlane":{
                preparedStatement = conn.prepareStatement(INSERT3);
                preparedStatement.setString(1,"Пассажирский самолет");
                preparedStatement.setDouble(2,((PassengerPlane) p).getRange());
                preparedStatement.setDouble(3,((PassengerPlane) p).getFuelCons());
                preparedStatement.setDouble(4,((PassengerPlane) p).getCapacity());
                preparedStatement.execute();
                break;
            }
        }
    }
}
