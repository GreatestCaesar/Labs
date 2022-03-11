package by.bsac.lab4.individual.DAO;

import by.bsac.lab4.individual.Objects.Planet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlSpaceDAO implements SpaceDAO {
    // 1 запрос
    // Вывести информацию обо всех планетах, на которых присутствует жизнь, и их
    //спутниках в заданной галактике
    private final static String SELECT_QUERY_PLANET = "select planets.name,planets.radius,planets.temperature,planets.atmosphere,planets.life,planets.satellites from planets join satellites join galaxy where planets.life='есть' and planets.satellites=satellites.name and galaxy.name = ?;";
    // 2 запрос
    // выводит количество спутников для каждой планеты
    private final static String SELECT_QUERY_SATELLITES = "select name, count(satellites) as count_satellites from planets group by name;";
    // 3 запрос
    // Информация о планетах, которые имеют спутников больше, чем задано пользователем
    private final static String SELECT_QUERY_SATELLITES2 = "select * from planets group by name having count(satellites)>?;";
    // 4 запрос
    // Планета с наименьшим радиусом
    private final static String SELECT_QUERY_PLANET2 = "SELECT * FROM planets ORDER BY radius=(select min(radius) from planets) DESC LIMIT 1;";

    @Override
    public void findLife(String galaxy) {
        Planet planet;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_PLANET);
            preparedStatement.setString(1, galaxy);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                planet = new Planet();
                planet.setName(result.getString(1));
                planet.setRadius(result.getInt(2));
                planet.setTemperature(result.getInt(3));
                planet.setAtmosphere(result.getString(4));
                planet.setLife(result.getString(5));
                planet.setSatellites(result.getString(6));
                System.out.println(planet);
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
    }

    @Override
    public void countSattelites() {
        Planet planet;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_SATELLITES);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                planet = new Planet();
                planet.setName(result.getString(1));
                System.out.println(planet.getName() + " - " + result.getInt(2));
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
    }

    @Override
    public void haveSattelites(int x) {

        Planet planet;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_SATELLITES2);
            preparedStatement.setInt(1, x);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                planet = new Planet();
                planet.setName(result.getString(1));
                planet.setRadius(result.getInt(2));
                planet.setTemperature(result.getInt(3));
                planet.setAtmosphere(result.getString(4));
                planet.setLife(result.getString(5));
                planet.setSatellites(result.getString(6));
                System.out.println(planet);
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
    }

    @Override
    public void radius() {
        Planet planet;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_PLANET2);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                planet = new Planet();
                planet.setName(result.getString(1));
                planet.setRadius(result.getInt(2));
                planet.setTemperature(result.getInt(3));
                planet.setAtmosphere(result.getString(4));
                planet.setLife(result.getString(5));
                planet.setSatellites(result.getString(6));
                System.out.println(planet);
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
    }
}
