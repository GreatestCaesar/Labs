package sample;

import java.sql.*;

public class Create {
    private static final String list = "show databases;";
    private static final String CREATE_DATABASE = "create database documents";
    private static final String CREATE_TABLE = "create table documents(id int not null primary key auto_increment, name varchar(255), department varchar(255), responsible varchar(255), type varchar(255), date date);";

    Connection connection = MysqlDAOFactory.createConnection("mysql");
    PreparedStatement preparedStatement = null;

    public Create() throws SQLException {
        int k=0;
        ResultSet result = null;
        preparedStatement = connection.prepareStatement(list);
        preparedStatement.execute();
        result = preparedStatement.getResultSet();
        while(result.next() && result != null){
           if(result.getString(1).equals("documents")){
               k++;
           }
        }

        if(k==0){
            preparedStatement = connection.prepareStatement(CREATE_DATABASE);
            preparedStatement.execute();
            connection = MysqlDAOFactory.createConnection();
            preparedStatement = connection.prepareStatement(CREATE_TABLE);
            preparedStatement.execute();
        }
    }
}
