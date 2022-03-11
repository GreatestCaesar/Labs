package individual;

public abstract class DAOFactory {
    /** Static member for mysql-factory. */
    public static final int MYSQL = 0;
    /** Abstract method for the StudentDAO. */
    public abstract ActorDAO getActorDAO();
    public abstract FilmDAO getFilmDAO();
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