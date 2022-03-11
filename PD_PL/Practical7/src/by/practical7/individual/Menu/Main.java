package by.practical7.individual.Menu;

import by.practical7.individual.Gift.GiftDAO;
import by.practical7.individual.Gift.NewYearGift;
import by.practical7.individual.Tools.Create;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ArrayList<NewYearGift> gift = new ArrayList<>();
        NewYearGift NYG = new NewYearGift();
        boolean k = true;
        char c;
        Scanner s = new Scanner(System.in);
        while(k){
            System.out.println("1. Укомплектовать подарок\n2. Просмотреть содержимое\n3. Записать в базу данных\n0. Выход");
            c = s.next().charAt(0);
            switch (c) {
                case '1': {
                    gift = NYG.CreateS(gift);
                    break;
                }
                case '2': {
                    boolean z = true;
                    char x;
                    while(z){
                        System.out.println("1. Общая информация\n2. Полная информация\n3. Вес подарка\n4. Сортировка(По сахару)\n5. Конфета попадающая в заданный диапазон сахара\n0. Назад");
                        x = s.next().charAt(0);
                        switch (x){
                            case '1':{
                                for(int i=0;i<gift.size();i++){
                                    System.out.println("#" + gift.get(i).getId() + " | Тип: " + gift.get(i).getType() + " | Название: " + gift.get(i).getName());
                                }
                                break;
                            }
                            case '2':{
                                for(int i=0;i<gift.size();i++){
                                    System.out.println("#" + gift.get(i).getId() + " | Тип: " + gift.get(i).getType() + " | Название: " + gift.get(i).getName() + " | Вес: " + gift.get(i).getWeight() + " | Сахар: " + gift.get(i).getSugar());
                                }
                                break;
                            }
                            case '3':{
                                double sum = 0;
                                for(int i=0;i<gift.size();i++){
                                    sum += gift.get(i).getWeight();
                                }
                                System.out.println("Вес подарек составляет: " + sum);
                                break;
                            }
                            case '4':{
                                gift = NYG.Sort(gift);
                                for(int i=0;i<gift.size();i++){
                                    System.out.println("#" + gift.get(i).getId() + " | Тип: " + gift.get(i).getType() + " | Название: " + gift.get(i).getName() + " | Вес: " + gift.get(i).getWeight() + " | Сахар: " + gift.get(i).getSugar());
                                }
                                break;
                            }
                            case '5':{
                                int a=0,b=0;
                                System.out.println("Введите начальное число: ");
                                a = s.nextInt();
                                System.out.println("Введите конечное числое: ");
                                b = s.nextInt();
                                for(int i=a;i<b;i++){
                                    //System.out.println("#" + gift.get(i).getId() + " | Тип: " + gift.get(i).getType() + " | Название: " + gift.get(i).getName() + " | Сахар: " + gift.get(i).getSugar());
                                }
                            }
                            case '0':{
                                z = false;
                                break;
                            }
                            default:{
                                System.err.println("Повторите ввод");
                                break;
                            }
                        }
                    }
                    break;
                }
                case '3':{
                    if(gift.size()==0){

                    }else{
                        Create.create();
                        Create.createTables();
                        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                        GiftDAO giftDAO = mysqlFactory.getGiftDAO();
                        giftDAO.insertInDB(gift);
                    }
                    break;
                }
                case '0': {
                    k = false;
                    break;
                }
                default:{
                    System.err.println("Повторите ввод");
                    break;
                }
            }
        }
    }
}
