package by.bsac.practical7.individual.Main;

import by.bsac.practical7.individual.Create.Create;
import by.bsac.practical7.individual.DAO.DAOFactory;
import by.bsac.practical7.individual.DAO.MotorcyclistDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner s = new Scanner(System.in);
        ArrayList<Motorcyclist> mot = new ArrayList<>();
        Motorcyclist moto = new Motorcyclist();
        Create.create();
        Create.createTables();
        boolean k = true;
        char c =' ';
        while (k){
            System.out.println("1. Экипировать\t2. Экипировать автоматически\t3. Просмотреть экипировку\t4. Стоимость экипировки\t5. Отсортировать по весу\t6. Найти элементы в диапазоне цены\t7. Записать данные в БД\t0. Выход");
            c = s.next().charAt(0);
            switch (c) {
                case '1': {
                    mot = moto.equip(mot);
                    break;
                }
                case '2':{
                    mot = moto.autoequip(mot);
                    break;
                }
                case '3':{
                    if(mot.size()==0){
                        System.out.println("Экипировка не надета");
                    }else {
                        for (Motorcyclist motorcyclist : mot) {
                            System.out.println(motorcyclist);
                        }
                    }
                    break;
                }
                case '4':{
                    double sum=0;
                    for(int i=0;i<mot.size();i++){
                        sum += mot.get(i).getPrice();
                    }
                    System.out.println("Стоимость экипировки: " + sum);
                    break;
                }
                case '5':{
                    mot = moto.sort(mot);
                    break;
                }
                case '6':{
                    double x,y;
                    System.out.print("Введите начало диапазона: ");
                    x = s.nextDouble();
                    System.out.print("Введите конец диапазона: ");
                    y = s.nextDouble();
                    System.out.println("Элементы: ");
                    for(int i=0;i< mot.size();i++){
                        if(mot.get(i).getPrice() >= x && mot.get(i).getPrice() <= y){
                            System.out.println(mot.get(i));
                        }
                    }
                    break;
                }
                case '7':{
                    if(mot.size()==0){
                        System.out.println("Нет данных для внесения в бд");
                    }else{
                        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                        MotorcyclistDAO motorcyclistDAO = mysqlFactory.getMotorcyclistDAO();
                        motorcyclistDAO.insertInDB(mot);
                    }
                    break;
                }
                case '0':{
                    k=false;
                    break;
                }
            }
        }
    }
}
