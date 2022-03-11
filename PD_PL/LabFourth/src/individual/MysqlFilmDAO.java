package individual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlFilmDAO implements FilmDAO {
    private static final String SELECT_QUERY = "select * from films where YEAR(films.year)=YEAR(NOW()) OR YEAR(films.year)=YEAR(NOW())-1;";
    private static final String DELETE_QUERY = "delete from films where YEAR(year)<YEAR(NOW())-?;";

    @Override
    public ArrayList<Film> outputFilm() {
        ArrayList<Film> films = new ArrayList<>();
        Film film = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                film = new Film();
                film.setName(result.getString(1));
                film.setDirector(result.getString(2));
                film.setActors(result.getString(3));
                film.setYear(result.getString(4));
                film.setCounty(result.getString(5));
                films.add(film);
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
        return films;
    }

    @Override
    public boolean delete(int n) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, n);
            preparedStatement.execute();
            return true;
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
        return false;
    }
}
