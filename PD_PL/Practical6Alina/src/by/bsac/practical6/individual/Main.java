package by.bsac.practical6.individual;//package task_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MyExeption, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Risk risk = new Risk();

        Derivativ[] derivativs = new Derivativ[risk.amountOfRisk];
        Thread sort = new Thread(new Sort(derivativs));                                             // создаём поток
        sort.start();                                                                               // запускам, он не работает, потому что во время синхронизации он ждёт команды для начала работы
        synchronized (derivativs) {
            for (int i = 0; i < derivativs.length; i++) {
                derivativs[i] = new Derivativ();
                derivativs[i].cost = (int) (Math.round(Math.random() * 250));
                derivativs[i].amountOfRisk = (int) (Math.round(Math.random() * 250));
                derivativs[i].degree = (int) (Math.round(Math.random() * 10));
            }

            System.out.println(risk);
            System.out.println();
            System.out.println("Не застрахован");
            for (int i = 0; i < derivativs.length; i++) {
                System.out.println(derivativs[i]);
            }

            System.out.println();
            System.out.println("Застрахован");


            derivativs.notify();                                                                                // даём команду остальным потокам, которые ждут
            derivativs.wait();                                                                                  // останавливаем данный поток
            for (int i = 0; i < derivativs.length; i++) {
                System.out.println(derivativs[i]);
            }

            int totalCost = 0;
            int totalRisk = 0;
            for (int i = 0; i < derivativs.length; i++) {
                totalCost += derivativs[i].cost;
                totalRisk += derivativs[i].amountOfRisk;
            }

            System.out.println();
            try {                                                                                                           // отлавливание собственного исключения
                if (totalRisk > 500) {
                    throw new MyExeption(totalCost);                                                                        // создание собственного исключения
                } else {
                    System.out.println("Total cost  is " + totalCost + ", total risk  is " + totalRisk);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            int left = 0; // 3
            int right = 0; // 8
            boolean flag = true;
            System.out.println();

            while (flag) {
                try {
                    flag = false;
                    System.out.println("Введите начальную точку диапазона: ");
                    left = scanner.nextInt();
                    if (left < 0 || left == 0) {
                        flag = true;
                        throw new MyException2(left);                                                                       // создание собственного исключения
                    }
                } catch (Exception e) {                                                                                       // обработка собственного исключения
                    System.out.println(e);
                }
            }

            flag = true;

            while (flag) {
                try {
                    flag = false;
                    System.out.println("Введите конечную точку диапазона: ");
                    right = scanner.nextInt();
                    if (right < 0 || right == 0) {
                        flag = true;
                        throw new MyException2(right);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            System.out.println("Derivativs have risk " + left + " and " + right + ":");
            for (int i = 0; i < derivativs.length; i++) {
                if (derivativs[i].degree > left && derivativs[i].degree < right) {
                    System.out.println(derivativs[i]);
                }
            }
        }
    }
}
