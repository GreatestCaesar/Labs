package sample;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DocumentDAO {
    ArrayList<Document> search(String where, String who)  throws SQLException;
    void add(Document newDoc) throws SQLException;
    void delete(Document delDoc) throws SQLException;
    void edit(Document upDoc) throws SQLException;
    ArrayList<Document> getAll() throws SQLException;
}
