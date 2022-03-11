package by.practical7.individual.Menu;

import by.practical7.individual.Gift.MysqlGiftDAO;

public abstract class DAOFactory {
    /** Static member for mysql-factory. */
    public static final int MYSQL = 0;
    /** Abstract method for the StudentDAO.
     * @return*/
    public abstract MysqlGiftDAO getGiftDAO();

    /**
     * Factory-method
     *
     * @param database the database to choose
     * @return a matching factory
     */
    public static MysqlDAOFactory getDAOFactory(int database) {
        switch (database) {
            case MYSQL:
                return new MysqlDAOFactory();
            default:
                return null;
        }
    }
}