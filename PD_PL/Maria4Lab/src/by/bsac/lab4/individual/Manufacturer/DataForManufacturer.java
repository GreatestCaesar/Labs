package by.bsac.lab4.individual.Manufacturer;

import by.bsac.lab4.individual.Main.MysqlDAOFactory;
import by.bsac.lab4.individual.Tools.DatafromFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataForManufacturer {
    private static final String INSERT = "insert into manufacturer (brand,country) values (?,?);"; /** Запрос для MySQL, где '?' служит как указателем, что необходимо вставить на данное место
                                                                                                    зависит от данных, которые будут изъяты из файла*/
    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    public static void filling() throws SQLException {
        String[] manufacturer;
        String[] manufacture;
        String temp = "";
        String txt = DatafromFile.readFile("E:\\PD&PL\\Maria4Lab\\src\\by\\bsac\\lab4\\individual\\Manufacturer\\","manufacturer.txt"); // указать путь к файлу manuf...
        conn = MysqlDAOFactory.createConnection();  /** установление соединения с БД */
        preparedStatement = conn.prepareStatement(INSERT); /** переменная, которая отправляет запрос в БД в качестве параметра метода
                                                                но для начала указывается свойства запроса, а затем он выполняется */
        manufacturer = txt.split("\n");
        for(int i=0;i< manufacturer.length;i++){
            temp = manufacturer[i];
            manufacture = temp.split("\\.");
            preparedStatement.setString(1, manufacture[0]); /** Как было описано выше, на место '?', вставляются данные, чтобы понять подробнее, см. примеры работы printf(%d) в Java */
            preparedStatement.setString(2, manufacture[1]);
            preparedStatement.execute(); /** Выполнение запроса */
        }
    }
}
