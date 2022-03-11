package by.bsac.practical6.individual.Participant;

import by.bsac.practical6.individual.Lots.Lots;

import java.util.Scanner;

public class Participant extends Thread {
    private String name; // имя
    private double bank; // сумма на руках
    private Lots lots; // приобретенные лоты
    private Lots auctionLots; // лоты аукциона
    private boolean active; // активен ли участник

    public Participant(String name, double bank, Lots lots) throws InterruptedException {
        super(name);
        this.name = name;
        this.bank = bank;
        this.lots = new Lots();
        this.auctionLots = lots;
        this.active = true;
    }

    public void run() {
        synchronized (auctionLots) {
            Scanner s = new Scanner(System.in);
            boolean f = true;
            String l;
            int z = 0;
            while (f) {
                int part = auctionLots.getPart();
                System.out.println(Thread.currentThread().getName());
                System.out.println("Вашему вниманию:");
                auctionLots.displayFirst();
                if (auctionLots.getPart() == 1) {
                    System.out.println("Поздравляем! Вы победили, картина теперь ваша!");
                    lots.insertFirst(auctionLots.getFirst());
                    auctionLots.deleteFirst();
                    auctionLots.notifyAll();
                    try {
                        auctionLots.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("1. Сделать ставку 2. Не учавствую 3. Мои деньги 4. Покинуть аукцион");
                l = s.nextLine();
                switch (l) {
                    case "1": {
                        System.out.println("Введите размер вашей ставки: ");
                        z = s.nextInt();
                        auctionLots.newPriceLot(z);
                        auctionLots.notify();
                        try {
                            auctionLots.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case "2": {
                        auctionLots.notify();
                        auctionLots.dropPart();
                        while (auctionLots.getPart() != part) {
                            try {
                                auctionLots.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                    case "3": {
                        System.out.println(bank);
                        break;
                    }
                    case "4": {
                        auctionLots.notifyAll();
                        auctionLots.dropPart();
                        f = false;
                        break;
                    }
                    default: {
                        System.out.println("Повторите ввод!");
                        break;
                    }
                }
            }
        }
    }
}
