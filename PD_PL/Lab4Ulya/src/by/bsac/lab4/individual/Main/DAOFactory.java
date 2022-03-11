package by.bsac.lab4.individual.Main;

import by.bsac.lab4.individual.Manufacturer.ManufacturerDAO;
import by.bsac.lab4.individual.Timer.WatchDAO;

import java.sql.SQLException;

public abstract class DAOFactory {
    /** Static member for mysql-factory. */
    public static final int MYSQL = 0;
    /** Abstract method for the StudentDAO. */
    public abstract ManufacturerDAO getManufacturerDAO();
    public abstract WatchDAO getWatchDAO();

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