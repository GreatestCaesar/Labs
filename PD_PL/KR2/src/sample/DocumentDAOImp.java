package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DocumentDAOImp implements DocumentDAO{
    private final String SELECT_ALL = "select * from documents;";
    private final String INSERT_NEW = "insert into documents (name,department,responsible,type,date) values(?,?,?,?,?);";
    private final String DELETE = "delete from documents where name=? and department=? and responsible=? and type=? and date=?;";
    private final String UPDATE = "update documents set name=?,department=?,responsible=?,type=?,date=? where id=?;";
    private final String FIND = "select * from documents where ";

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    @Override
    public ArrayList<Document> search(String where, String who) throws SQLException {
        connection = MysqlDAOFactory.createConnection();
        statement = connection.prepareStatement(FIND + where + "=?;");
        Document document = null;
        ArrayList<Document> documents = new ArrayList<>();
        statement.setString(1, who);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            document = new Document();
            document.setId(resultSet.getInt(1));
            document.setName(resultSet.getString(2));
            document.setDepartment(resultSet.getString(3));
            document.setResponsible(resultSet.getString(4));
            document.setType(resultSet.getString(5));
            document.setDate(resultSet.getString("date"));
            documents.add(document);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return documents;
    }

    @Override
    public void add(Document newDoc) throws SQLException {
        connection = MysqlDAOFactory.createConnection();
        statement = connection.prepareStatement(INSERT_NEW);
        statement.setString(1, newDoc.getName());
        statement.setString(2, newDoc.getDepartment());
        statement.setString(3, newDoc.getResponsible());
        statement.setString(4, newDoc.getType());
        statement.setString(5, newDoc.getDate());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void delete(Document delDoc) throws SQLException {
        connection = MysqlDAOFactory.createConnection();
        statement = connection.prepareStatement(DELETE);
        statement.setString(1, delDoc.getName());
        statement.setString(2, delDoc.getDepartment());
        statement.setString(3, delDoc.getResponsible());
        statement.setString(4, delDoc.getType());
        statement.setString(5, delDoc.getDate());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void edit(Document upDoc) throws SQLException {
        connection = MysqlDAOFactory.createConnection();
        statement = connection.prepareStatement(UPDATE);
        statement.setString(1, upDoc.getName());
        statement.setString(2, upDoc.getDepartment());
        statement.setString(3, upDoc.getResponsible());
        statement.setString(4, upDoc.getType());
        statement.setString(5, upDoc.getDate());
        statement.setInt(6, upDoc.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public ArrayList<Document> getAll() throws SQLException {
        connection = MysqlDAOFactory.createConnection();
        Document document = null;
        ArrayList<Document> documents = new ArrayList<>();
        statement = connection.prepareStatement(SELECT_ALL);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            document = new Document();
            document.setId(resultSet.getInt(1));
            document.setName(resultSet.getString(2));
            document.setDepartment(resultSet.getString(3));
            document.setResponsible(resultSet.getString(4));
            document.setType(resultSet.getString(5));
            document.setDate(resultSet.getString("date"));
            documents.add(document);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return documents;
    }
}
