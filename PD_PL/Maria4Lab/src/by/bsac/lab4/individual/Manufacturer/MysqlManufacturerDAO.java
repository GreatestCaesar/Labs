package by.bsac.lab4.individual.Manufacturer;

import by.bsac.lab4.individual.Main.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlManufacturerDAO implements ManufacturerDAO{ /** Интерфейс указывает, какие методы в любом случае должен иметь класс, которые работает с определенной таблице */
    public static final String SELECT_QUERY = "select distinct manufacturer.brand from manufacturer join watch where (select sum(watch.price) from watch where (select locate(manufacturer.brand,watch.brand)) <> 0) < ?;";
    /** Специальны запрос, для демонстрации взаимодействия */

    @Override
    public ArrayList<Manufacturer> outManWhereSum(double l) {   /** метод для выполнения запросы выше */
        ArrayList<Manufacturer> manufacturers = new ArrayList<Manufacturer>(); /** Список Производители, который будет хранить в себе данные из БД */
        Manufacturer manufacturer = null; /** Объект, который будет заполнятся данными и входить в список Производители */
        Connection conn = null; /** установление соединения */
        PreparedStatement preparedStatement = null; /** параметры, для задания корректного запроса */
        ResultSet result = null; /** результат, возвращаемы из БД */
        int b = 0;
        try {
            conn = MysqlDAOFactory.createConnection(); /** соединение */
            preparedStatement = conn.prepareStatement(SELECT_QUERY); /** указание, какой запрос необходимо выполнить */
            preparedStatement.setDouble(1, l); /** указания свойства данного запросы '?', (для понятия принципа работы см. printf() в Java */
            preparedStatement.execute();    /** выполнение запроса */
            result = preparedStatement.getResultSet(); /** сохранение результата, которые вернёт запрос */
            while (result.next() && result != null) { /** т.к. результат хранится не в виде массива и нет индексации, даные извлекаются пока есть следующий элемент и не конец списка */
                manufacturer = new Manufacturer();
                manufacturer.setBrand(result.getString(1)); /** установления свойтсва Производителя из 1 колонки таблицы, потому что данные в MySQL хранятся в виде таблицы */
                manufacturers.add(manufacturer); /** добавление производителя в список */
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
        return manufacturers;
    }
}
