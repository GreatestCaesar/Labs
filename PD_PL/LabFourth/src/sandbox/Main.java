package sandbox;


import java.sql.*;

public class Main {
    private static final String CREATE_QUERY_FILMS = "insert into films (name,director,actors,year,country) values (?,?,?,?,?);";
    private static final String CREATE_QUERY_ACTORS = "insert into actors values (?,?,?,?,?);";
    private static final String CREATE_QUERY_DIRECTORS = "insert into directors values (?,?,?,?);";
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        String temp = "";
        String[] fil = null;
        String[] acto = null;
        String[] directo = null;
        String films = DatafromFile.readFile("E:\\PD&PL\\LabFourth\\src\\sandbox\\", "films.txt");
        String actors = DatafromFile.readFile("E:\\PD&PL\\LabFourth\\src\\sandbox\\", "actors.txt");
        String directors = DatafromFile.readFile("E:\\PD&PL\\LabFourth\\src\\sandbox\\", "directors.txt");
        String[] film = films.split("\n");
        conn = Connect.createConnection();
        /*preparedStatement = conn.prepareStatement(CREATE_QUERY_FILMS);
        for (int i = film.length-1; i >= 0; i--) {
            temp = film[i];
            fil = String.valueOf(temp).split("\\.");
            for(int l=0;l<fil.length;l++){
                preparedStatement.setString((l+1), fil[l]);
            }
            preparedStatement.execute();
        }*/
        temp = "";
        String[] actor = actors.split("\n");
        preparedStatement = conn.prepareStatement(CREATE_QUERY_ACTORS);
        for(int i=0;i<actor.length;i++){
            temp = actor[i];
            acto = String.valueOf(temp).split("\\.");
            for(int l=0;l<acto.length;l++){
                preparedStatement.setString((l+1), acto[l]);
            }
            preparedStatement.execute();
        }
        /*temp = "";
        String[] director = directors.split("\n");
        preparedStatement = conn.prepareStatement(CREATE_QUERY_DIRECTORS);
        for(int i=0;i< director.length;i++){
            temp = director[i];
            directo = String.valueOf(temp).split("\\.");
            for(int j=0;j< directo.length;j++){
                preparedStatement.setString((j+1), directo[j]);
            }
            preparedStatement.execute();
        }*/
    }
}
