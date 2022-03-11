package by.bsac.lab4.individual.DAO;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Класс, который отвечает за подключение к MySQL и БД, своего рода прослойка, для соединения среды разработки и БД
 * DAO служит, как модуль, которые можно заменить не изменяя сам главный код, например, если вы смените средства для работы с БД, чтобы не перестраивать структуру ваша проекта
 * */

public class MysqlDAOFactory extends DAOFactory {
    /**
     * Наследование от DAOFactory, так как класс родитель может служить набором БД, к которым можно подключиться, но в нашем случае только MySQL
     * Также родитель имеет абстрактные методы, которые должны переодпределить наследники, но со своими свойствами для
     * определенных БД
     */
    public static String DB_HOST = "localhost";
    /**
     * Указание для URL, если БД находится на сервере, чтоб программа могла знать её адрес, в нашем случае это наш собственный ПК
     */
    public static String DB_PORT = "3306";
    /**
     * Порт для MySQL: 3306 - стандарт
     */
    public static String DB_USER = "root";
    /**
     * Имя администратора MySQL
     */
    public static String DB_PASSWORD = "1234";
    /**
     * Пароль от вашего MySQL ОБЯЗАТЕЛЬНО ПРОВЕРИТЬ ПЕРЕД ЗАПУСКОМ
     */
    public static String DB_NAME = "store";
    /**
     * Название БД, если она не создана, либо названа неправильно ПРОГРАММА РАБОТАТЬ НЕ БУДЕТ
     */
    public static Connection connection;

    /**
     * Класс из средства для работы с SQL, который хранит в себе адрес соединения
     */

    public static Connection createConnection() {
        String url = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME +                                                /** Создание URL для указания драйверу, куда необходимо подключаться */
                "?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Properties prop = new Properties();              /** Класс, который служит пулом настроек, необходимых для определенных действий, в нашем случаае работы драйвера */
        prop.put("user", DB_USER);
        prop.put("password", DB_PASSWORD);
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        try {
            DriverManager.registerDriver(new Driver());                 /** Создание экзмепляра Драйвре, для дальнейшего установления соединения */
            connection = DriverManager.getConnection(url, prop);        /**  */
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        }
        return connection;
    }

    /** Как и говорилось в описании класса, методы служат для того, чтобы показать остальным пользователям, либо тем, кто будет работать
     с программой, какие классы должна иметь программа, сами классы отвечают за взаимодествие с определенным таблицами, в зависимости
     от требований */
    @Override
    public BooksDAO getBooksDAO() {
        return new MysqlBooksDAO();
    }
}
