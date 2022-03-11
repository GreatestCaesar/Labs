package by.bsac.practical7.individual.Main;

import by.bsac.practical7.individual.DB.DAOFactory;
import by.bsac.practical7.individual.DB.TaxesDAO;
import by.bsac.practical7.individual.Tools.Create;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Taxes[] tax = new Taxes[3];
        Taxes t = new Taxes();

        tax = t.create(tax);
        Create.create();
        Create.createTables();
        for (int i=0;i<tax.length;i++){
            System.out.println(tax[i]);
        }
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        TaxesDAO taxesDAO = mysqlFactory.getTaxesDAO();
        taxesDAO.insertInDB(tax);
        tax = t.sort(tax);

        for (int i=0;i<tax.length;i++){
            System.out.println(tax[i]);
        }
    }
}
