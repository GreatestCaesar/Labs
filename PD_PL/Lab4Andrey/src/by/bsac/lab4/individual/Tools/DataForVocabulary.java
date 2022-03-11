package by.bsac.lab4.individual.Tools;

import by.bsac.lab4.individual.DAO.MysqlDAOFactoryBY;
import by.bsac.lab4.individual.DAO.MysqlDAOFactoryRU;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataForVocabulary{
    private static final String INSERT1 = "insert into ru (word_ru,word_by) values (?,?);"; /** Запрос для MySQL, где '?' служит как указателем, что необходимо вставить на данное место
                                                                                                    зависит от данных, которые будут изъяты из файла*/
    private static final String INSERT2 = "insert into byy (word_by,word_ru) values (?,?);";
    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    public static void filling() throws SQLException {
        String temp = "";
        String ru = DatafromFile.readFile("E:\\PD&PL\\Lab4Andrey\\src\\by\\bsac\\lab4\\individual\\Vocabulary\\RU.txt"); // указать путь к файлу ...
        String by = DatafromFile.readFile("E:\\PD&PL\\Lab4Andrey\\src\\by\\bsac\\lab4\\individual\\Vocabulary\\BY.txt"); // указать путь к файлу ...
        String[] ru2 = ru.split("\n");
        String[] by2 = by.split("\n");
        String[] ru3;
        String[] by3;
        conn = MysqlDAOFactoryRU.createConnection();  /** установление соединения с БД */
        preparedStatement = conn.prepareStatement(INSERT1); /** переменная, которая отправляет запрос в БД в качестве параметра метода
         но для начала указывается свойства запроса, а затем он выполняется */
        for(int i=0;i<ru2.length;i++){
            temp = ru2[i];
            ru3 = temp.split("_");
            preparedStatement.setString(1, ru3[0]); /** Как было описано выше, на место '?', вставляются данные, чтобы понять подробнее, см. примеры работы printf(%d) в Java */
            preparedStatement.setString(2, ru3[1]);
            preparedStatement.execute(); /** Выполнение запроса */
        }

        conn = MysqlDAOFactoryBY.createConnection();  /** установление соединения с БД */
        preparedStatement = conn.prepareStatement(INSERT2); /** переменная, которая отправляет запрос в БД в качестве параметра метода */
        for(int i=0;i<by2.length;i++){
            temp = by2[i];
            by3 = temp.split("_");
            preparedStatement.setString(1, by3[0]); /** Как было описано выше, на место '?', вставляются данные, чтобы понять подробнее, см. примеры работы printf(%d) в Java */
            preparedStatement.setString(2, by3[1]);
            preparedStatement.execute(); /** Выполнение запроса */
        }
    }
}
