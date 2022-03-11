package example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//конкретная реализация взаимодействия с моделью данных
public class MysqlStudentDAO implements StudentDAO {
    /** The query for creation. */
    private static final String CREATE_QUERY = "insert into students (personal_id, name,course, group_number) values (?,?,?,?);";
    /** The query for read. */
    private static final String READ_BY_PERSONAL_ID_QUERY = "SELECT personal_id,name, course, group_number FROM students WHERE personal_id = ?";
    /** The query for read. */
    private static final String READ_BY_SYSTEM_ID_QUERY = "SELECT personal_id, name,course, group_number FROM students WHERE id = ? and id = ?";
    /** The query for update. */
    private static final String UPDATE_QUERY = "UPDATE students SET personal_id=?,name=?, course=?, group_number=? WHERE personal_id = ?";
    /** The query for delete. */
    private static final String DELETE_QUERY = "DELETE FROM students WHEREpersonal_id = ?";
    @Override
    public int create(Student student) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, student.getPersonalNumber());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getCourse());
            preparedStatement.setString(4, student.getGroupNumber());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();
            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println("Error - closing result:" + rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println("Error - closing prepared statement" + sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
        return -1;
    }
    @Override
    public Student readByPersonalId(int personalId) {
        Student student = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(READ_BY_PERSONAL_ID_QUERY);
            preparedStatement.setInt(1, personalId);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            if (result.next() && result != null) {
                student = new Student();
                student.setPersonalNumber(result.getInt(1));
                student.setName(result.getString(2));
                student.setCourse(result.getInt(3));
                student.setGroupNumber(result.getString(4));
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
        return student;
    }
    @Override
    public boolean update(Student student) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(1, student.getPersonalNumber());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getCourse());
            preparedStatement.setString(4, student.getGroupNumber());
            preparedStatement.setInt(5, student.getPersonalNumber());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
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
        return false;
    }
    @Override
    public boolean delete(int personalId) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, personalId);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
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
        return false;
    }
    @Override
    public Student readBySystemlId(int systemId) {
        Student student = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(READ_BY_SYSTEM_ID_QUERY);
            preparedStatement.setInt(1, systemId);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            if (result.next() && result != null) {
                student = new Student();
                student.setPersonalNumber(result.getInt(1));
                student.setName(result.getString(2));
                student.setCourse(result.getInt(3));
                student.setGroupNumber(result.getString(4));
            } else {
                // TODO
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
        return student;
    }
}
