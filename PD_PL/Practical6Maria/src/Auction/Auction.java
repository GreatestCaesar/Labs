package Auction;

import Lots.Lots;
import Participant.Participant;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Auction {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        ArrayList<Participant> participants = new ArrayList<>();
        int m = 0;
        int z = 0;
        String name;
        double bank;
        Lots lots = new Lots();
        lots.insertFirst("Мона Лиза","Леонардо да Винчи", 12000000,0);
        lots.insertFirst("Сикстинская Мадонна","Рафаэль Санти", 3040000,0);
        lots.insertFirst("Свобода ведущая народ","Эжен Делакруа", 578000,0);
        lots.insertFirst("Две сестры","Пьер Огюст Ренуар", 8050000,0);
        lots.insertFirst("Девушка с серьгой","Ян Вермеер", 780000,0);
        int size = lots.size()-1;
        boolean k = true;
        boolean flag = true;
        String l;

        synchronized (lots) {
            while (k) {
                System.out.println("1. Новый участник 2. Начать торги 3. Выход");
                l = s.nextLine();
                switch (l){
                    case "1":{
                        if(flag) {
                            System.out.println("Имя участника: ");
                            name = s.nextLine();
                            System.out.println("Денежные средства участника: ");
                            bank = s.nextDouble();
                            Participant participant = new Participant(name, bank, lots);
                            participants.add(participant);
                            break;
                        }else{
                            System.out.println("Аукцион идёт, новые участники не могут присутствовать");
                        }
                    }
                    case "2":{
                        if(lots.size()==0){
                            System.out.println("Лотов больше нет!");
                        }else {
                            flag = false;
                            lots.setPart(participants.size());
                            if (participants.size() != 0) {
                                while (z < participants.size()) {
                                    participants.get(z).start();
                                    z++;
                                }
                                lots.notifyAll();
                                while (lots.size() != size) {
                                    lots.wait();
                                }
                                size = lots.size() - 1;
                            } else {
                                System.out.println("Участников нет!");
                            }
                        }
                        break;
                    }
                    case "3":{
                        k = false;
                        break;
                    }
                    default:{
                        System.out.println("Повторите ввод");
                        break;
                    }
                }
            }
        }
    }
}
