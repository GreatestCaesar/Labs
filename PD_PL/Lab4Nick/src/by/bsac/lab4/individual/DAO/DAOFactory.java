package by.bsac.lab4.individual.DAO;

public abstract class DAOFactory {/** Класс, который служит для наследников, как указатель, к каким базам данных может подключаться данная программа, в нашем случае только MySQL
 необходим для поддерживания принципов ООП, т.к. нельзя встраивать в классы, которые служат для работы с таблицами, либо главного класса, чтобы пользователь мог зайти и указать, какие ему
 необходимы базы данных, не вмешиваясь в работу всей структуры (ИНКАПУСЛЯЦИЯ)
 */
    /** Static member for mysql-factory. */
    public static final int MYSQL = 0;
    /** Abstract method for the StudentDAO. */
    /** Указывает наследникам, с каким таблицами необходимо работать в БД */
    public abstract BooksDAO getBooksDAO();

    /**
     * Factory-method
     *
     * @param database the database to choose
     * @return a matching factory
     */
    public static MysqlDAOFactory getDAOFactory(int database) {   /** Возвращает класс, необходимый для работы с определенной БД */
        switch (database) {
            case MYSQL:
                return new MysqlDAOFactory();
            default:
                return null;
        }
    }

}
