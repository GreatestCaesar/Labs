package by.bsac.lab4.individual.Create;

import by.bsac.lab4.individual.DAO.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataForStore {
    private static final String INSERT1 = "INSERT INTO KNIGA VALUES(?,?,?,?,?,?);"; /** Запрос для MySQL, где '?' служит как указателем, что необходимо вставить на данное место
                                                                                                    зависит от данных, которые будут изъяты из файла*/
    private static final String INSERT2 = "INSERT INTO KNIGA_PRODAGA VALUES(?,?,?,?,?);";

    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    public static void filling() throws SQLException {
        String txt1 = DatafromFile.readFile("src/by/bsac/lab4/individual/Data/KNIGA.txt"); // указать путь к файлу
        String txt2 = DatafromFile.readFile("src/by/bsac/lab4/individual/Data/KNIGA_PRODAGA.txt"); // указать путь к файлу


        conn = MysqlDAOFactory.createConnection();  /** установление соединения с БД */
        kniga(txt1,INSERT1,conn);
        knigaProdaga(txt2,INSERT2,conn);
    }

    public static void kniga(String txt, String ins, Connection conn) throws SQLException {
        preparedStatement = conn.prepareStatement(ins);/** переменная, которая отправляет запрос в БД в качестве параметра метода
         но для начала указывается свойства запроса, а затем он выполняется */
        String temp;
        String[] book;
        String[] books = txt.split("\n");
        for(int i=0;i<books.length;i++){
            temp = books[i];
            book = temp.split("_");
            preparedStatement.setInt(1,Integer.parseInt(book[0]));
            preparedStatement.setString(2,book[1]);
            preparedStatement.setString(3,book[2]);
            preparedStatement.setDouble(4,Double.parseDouble(book[3]));
            preparedStatement.setString(5,book[4]);
            preparedStatement.setString(6,book[5]);
            preparedStatement.execute();
        }
    }

    public static void knigaProdaga(String txt, String ins, Connection conn) throws SQLException {
        preparedStatement = conn.prepareStatement(ins);
        String temp;
        String[] book;
        String[] books = txt.split("\n");
        for(int i=0;i<books.length;i++){
            temp = books[i];
            book = temp.split("_");
            preparedStatement.setInt(1,Integer.parseInt(book[0]));
            preparedStatement.setInt(2,Integer.parseInt(book[1]));
            preparedStatement.setString(3,book[2]);
            preparedStatement.setString(4,book[3]);
            preparedStatement.setString(5, book[4]);
            preparedStatement.execute();
        }
    }
}
