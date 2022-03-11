package by.bsac.practical5.individual.Task4fromLab;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws MyException {
        Scanner s = new Scanner(System.in);
        ArrayList<Motorcyclist> mot = new ArrayList<>();
        Motorcyclist moto = new Motorcyclist();
        boolean k = true;
        char c =' ';
        while (k){
            System.out.println("1. Экипировать\t2. Экипировать автоматически\t3. Просмотреть экипировку\t4. Стоимость экипировки\t5. Отсортировать по весу\t6. Найти элементы в диапазоне цены\t0. Выход");
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
                case '0':{
                    k=false;
                    break;
                }
                default:{
                    try {  // создание и обработка собственного исключения
                        throw new MyException(c);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        }
    }
}
