package by.bsac.lab4.individual.Create;

import by.bsac.lab4.individual.DAO.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataForSpace {
    private static final String INSERT1 = "insert into planets (name,radius,temperature,atmosphere,life,satellites) values (?,?,?,?,?,?);"; /** Запрос для MySQL, где '?' служит как указателем, что необходимо вставить на данное место
                                                                                                    зависит от данных, которые будут изъяты из файла*/
    private static final String INSERT2 = "insert into satellites (name,radius,distance) values (?,?,?);";
    private static final String INSERT3 = "insert into galaxy(name,planet) values (?,?);";
    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    public static void filling() throws SQLException {
        String[] manufacturer;
        String[] manufacture;
        String temp = "";
        String txt1 = DatafromFile.readFile("src/by/bsac/lab4/individual/Data/Планета.txt"); // указать путь к файлу
        String txt2 = DatafromFile.readFile("src/by/bsac/lab4/individual/Data/Спутник.txt"); // указать путь к файлу
        String txt3 = DatafromFile.readFile("src/by/bsac/lab4/individual/Data/Галактика.txt"); // указать путь к файлу


        conn = MysqlDAOFactory.createConnection();  /** установление соединения с БД */
        planet(txt1,INSERT1,conn);
        satellites(txt2,INSERT2,conn);
        galaxy(txt3,INSERT3,conn);
    }

    public static void planet(String txt, String ins, Connection conn) throws SQLException {
        preparedStatement = conn.prepareStatement(ins);/** переменная, которая отправляет запрос в БД в качестве параметра метода
         но для начала указывается свойства запроса, а затем он выполняется */
        String temp;
        String[] planet;
        String[] planets = txt.split("\n");
        for(int i=0;i<planets.length;i++){
            temp = planets[i];
            planet = temp.split("_");
            preparedStatement.setString(1,planet[0]);
            preparedStatement.setInt(2, Integer.parseInt(planet[1]));
            preparedStatement.setInt(3, Integer.parseInt(planet[2]));
            preparedStatement.setString(4,planet[3]);
            preparedStatement.setString(5,planet[4]);
            preparedStatement.setString(6,planet[5]);
            preparedStatement.execute();
        }
        System.out.println("Данные для таблицы \'Planets\' сохранены");
    }

    public static void satellites(String txt, String ins, Connection conn) throws SQLException {
        preparedStatement = conn.prepareStatement(ins);
        String temp;
        String[] sitellite;
        String[] sitellites = txt.split("\n");
        for(int i=0;i<sitellites.length;i++){
            temp = sitellites[i];
            temp = temp.trim();
            sitellite = temp.split("_");
            preparedStatement.setString(1,sitellite[0]);
            preparedStatement.setInt(2, Integer.parseInt(sitellite[1]));
            preparedStatement.setInt(3, Integer.parseInt(sitellite[2]));
            preparedStatement.execute();
        }
        System.out.println("Данные для таблицы \'Satellites\' сохранены");
    }

    public static void galaxy(String txt, String ins, Connection conn) throws SQLException{
        preparedStatement = conn.prepareStatement(ins);
        String temp;
        String[] galaxy;
        String[] galaxies = txt.split("\n");
        for(int i=0;i<galaxies.length;i++){
            temp = galaxies[i];
            galaxy = temp.split("_");
            preparedStatement.setString(1,galaxy[0]);
            preparedStatement.setString(2,galaxy[1]);
            preparedStatement.execute();
        }
        System.out.println("Данные для таблицы \'Galaxy\' сохранены");
    }
}
