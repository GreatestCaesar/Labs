package by.bsac.lab4.individual.Main;

import by.bsac.lab4.individual.DAO.MysqlVocabularyDAO;
import by.bsac.lab4.individual.Tools.Create;
import by.bsac.lab4.individual.Tools.DataForVocabulary;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner s = new Scanner(System.in);
        Create.create();
        Create.createTables();
        DataForVocabulary.filling();
        char l;
        boolean k = true;
        String txt;
        while (k){
            System.out.println("Перевод: \n1. Русский-Белорусский \n2. Белорусский-Русский \n3. Выход");
            l = s.next().charAt(0);
            switch (l) {
                case '1': {
                    System.out.println("Введите слово: ");
                    txt = s.next();
                    System.out.println(MysqlVocabularyDAO.getVocabularyDAO("ru",txt));
                    break;
                }
                case '2': {
                    System.out.println("Введите слово: ");
                    txt = s.next();
                    System.out.println(MysqlVocabularyDAO.getVocabularyDAO("by",txt));
                    break;
                }
                case '3':{
                    k = false;
                    break;
                }
                default:{
                    System.out.println("Ошибка ввода");
                    break;
                }
            }
        }
    }
}
