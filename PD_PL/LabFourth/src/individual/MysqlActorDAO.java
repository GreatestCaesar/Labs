package individual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlActorDAO implements ActorDAO{
    private static final String SELECT_QUERY_FILM = "select second_name,first_name,patronymic,DOB,num_of_films from actors join films where ((select locate(actors.second_name,films.actors)) <> 0 and films.name = ?);";
    private static final String SELECT_QUERY_NUM_FILM = "select * from actors where num_of_films > ?";
    private static final String SELECT_QUERY_DIR = "select second_name,first_name,patronymic,DOB from directors join films where (select locate(directors.second_name,films.actors) <> 0);";

    @Override
    public ArrayList<Actor> outputANF(String film) {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Actor actor = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_FILM);
            preparedStatement.setString(1, film);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                actor = new Actor();
                actor.setSecond_name(result.getString(1));
                actor.setFirst_name(result.getString(2));
                actor.setPatronymic(result.getString(3));
                actor.setDOB(result.getString(4));
                actor.setNumOfFilm(result.getInt(5));
                actors.add(actor);
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
        return actors;
    }

    @Override
    public ArrayList<Actor> outputAQF(int n) {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Actor actor = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_NUM_FILM);
            preparedStatement.setInt(1, n);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                actor = new Actor();
                actor.setSecond_name(result.getString(1));
                actor.setFirst_name(result.getString(2));
                actor.setPatronymic(result.getString(3));
                actor.setDOB(result.getString(4));
                actor.setNumOfFilm(result.getInt(5));
                actors.add(actor);
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
        return actors;
    }

    @Override
    public ArrayList<Actor> outputADF() {
        ArrayList<Actor> actors = new ArrayList<>();
        Actor actor = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(SELECT_QUERY_DIR);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            while (result.next() && result != null) {
                actor = new Actor();
                actor.setSecond_name(result.getString(1));
                actor.setFirst_name(result.getString(2));
                actor.setPatronymic(result.getString(3));
                actor.setDOB(result.getString(4));
                actors.add(actor);
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
        return actors;
    }
}
