package by.bsac.lab4.individual.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlVocabularyDAO{ /** Интерфейс указывает, какие методы в любом случае должен иметь класс, которые работает с определенной таблице */
    public static final String SELECT_QUERY1 = "select word_ru,word_by from ru where word_ru=?;";
    public static final String SELECT_QUERY2 = "select word_by,word_ru from byy where word_by=?;";
    /** Специальны запрос, для демонстрации взаимодействия */

    public static String getVocabularyDAO(String ans, String t) {   /** метод для выполнения запросы выше */
        Connection conn = null; /** установление соединения */
        PreparedStatement preparedStatement = null; /** параметры, для задания корректного запроса */
        ResultSet result = null; /** результат, возвращаемы из БД */
        try {
            switch (ans){
                case "ru":{
                    conn = MysqlDAOFactoryRU.createConnection(); /** соединение */
                    preparedStatement = conn.prepareStatement(SELECT_QUERY1); /** указание, какой запрос необходимо выполнить */
                    preparedStatement.setString(1, t); /** указания свойства данного запросы '?', (для понятия принципа работы см. printf() в Java */
                    preparedStatement.execute();    /** выполнение запроса */
                    result = preparedStatement.getResultSet(); /** сохранение результата, которые вернёт запрос */
                    while (result.next() && result != null) { /** т.к. результат хранится не в виде массива и нет индексации, даные извлекаются пока есть следующий элемент и не конец списка */
                        t += " - " + result.getString(2);
                    }
                    break;
                }
                case "by":{
                    conn = MysqlDAOFactoryBY.createConnection(); /** соединение */
                    preparedStatement = conn.prepareStatement(SELECT_QUERY2); /** указание, какой запрос необходимо выполнить */
                    preparedStatement.setString(1, t); /** указания свойства данного запросы '?', (для понятия принципа работы см. printf() в Java */
                    preparedStatement.execute();    /** выполнение запроса */
                    result = preparedStatement.getResultSet(); /** сохранение результата, которые вернёт запрос */
                    while (result.next() && result != null) { /** т.к. результат хранится не в виде массива и нет индексации, даные извлекаются пока есть следующий элемент и не конец списка */
                        t += " - " + result.getString(2);
                    }
                    break;
                }
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
        return t;
    }
}