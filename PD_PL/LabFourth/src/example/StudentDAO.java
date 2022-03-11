package example;

public interface StudentDAO {
    /** Creates a river and returns the id. */
    public int create(Student person);
    /** Receives a river by given personal id. */
    public Student readByPersonalId(int personalId);
    /** Receives a river by given system id. */
    public Student readBySystemlId(int systemId);
    /** Updates an existing river. */
    public boolean update(Student student);
    /** Deletes a river by id. */
    public boolean delete(int id);
}
