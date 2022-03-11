package example;

public class TestDAO {
    public static void main(String[] args) {
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        StudentDAO studentDAO = mysqlFactory.getStudentDAO();
        // CREATE
        Student student = new Student();
        student.setPersonalNumber(1);
        student.setName("Arsenij Alferov");
        student.setCourse(1);
        student.setGroupNumber("SP441");
        int systemId = studentDAO.create(student);
        System.out.println("Student's system id = " + systemId);
        // READ
        Student studentFromDB1 = studentDAO.readBySystemlId(systemId);
        System.out.println("after create: " + studentFromDB1);
        /*// UPDATE
        studentFromDB1.setGroupNumber("SP442");
        studentDAO.update(studentFromDB1);
        // READ
        Student studentFromDB2 = studentDAO.readBySystemlId(systemId);
        System.out.println("after update: " + studentFromDB2);
        // DELETE
        studentDAO.delete(studentFromDB2.getPersonalNumber());*/
    }
}
