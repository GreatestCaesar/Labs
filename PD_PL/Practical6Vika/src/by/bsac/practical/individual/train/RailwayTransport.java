package by.bsac.practical.individual.train;

import by.bsac.practical.individual.carriage.FirstClassCarriage;
import by.bsac.practical.individual.carriage.General;
import by.bsac.practical.individual.carriage.Locomotive;
import by.bsac.practical.individual.carriage.SecondClassCarriage;
import by.bsac.practical.individual.main.Lock;

import java.util.Arrays;
import java.util.Scanner;

public class RailwayTransport  extends Thread{
	private Lock lock;

	public RailwayTransport(String name,Lock lock){
		super(name);
		this.lock = lock;
		start();
	}

	Locomotive locomotive=new Locomotive();
	General general=new General();
	SecondClassCarriage secondClassCarriage=new SecondClassCarriage();
	FirstClassCarriage firstClassCarriage=new FirstClassCarriage();
	int counter1=locomotive.Counter();
	int counter2=general.Counter();
	int counter3=secondClassCarriage.Counter();
	int counter4=firstClassCarriage.Counter();
	public int getCounter1() {
		return counter1;
	}

	public void setCounter1(int counter1) {
		this.counter1 = counter1;
	}

	public int getCounter2() {
		return counter2;
	}

	public void setCounter2(int counter2) {
		this.counter2 = counter2;
	}

	public int getCounter3() {
		return counter3;
	}

	public void setCounter3(int counter3) {
		this.counter3 = counter3;
	}

	public int getCounter4() {
		return counter4;
	}

	public void setCounter4(int counter4) {
		this.counter4 = counter4;
	}

	public void run(){
		synchronized (lock){
			System.out.println("Сейчас в мониторе - " + Thread.currentThread().getName());
			switch (lock.getLock()){
				case 1:{
					Range();
					lock.setLock(lock.getLock()+1);
					break;
				}
				case 2:{
					Sort();
					lock.setLock(lock.getLock()+1);
					break;
				}
				case 3:{
					TotalNumber(getCounter1(),getCounter2(),getCounter3(),getCounter4());
					break;
				}
			}
		}
	}

	public int[] TotalNumber(int counter1, int counter2, int counter3, int counter4) {
		int [] totalNumber=new int[2];
		int totalSeats;
		int totalLuggage;
		totalSeats=counter2*81+counter3*36+counter4*18;
		totalLuggage=totalSeats*30;
		System.out.println("Общее количество пассажиров: "+totalSeats);
		System.out.println("Общее количество багажа (среднее количество на одного пассажира 30 кг): "+totalLuggage);
		totalNumber[0]=totalSeats;
		totalNumber[1]=totalLuggage;
		return totalNumber;
	}

	public void Sort() {
		int [] comfort=new int[3];
		comfort[0]=1;
		comfort[1]=2;
		comfort[2]=0;

		for(int i=0; i<comfort.length; i++) {
			for(int j=i+1; j<comfort.length; j++ )
				if(comfort[i]>comfort[j]) {
					int temp=comfort[i];
					comfort[i]=comfort[j];
					comfort[j]=temp;

				}

		}



		System.out.println("Сортировка вагонов поезда на основе уровня комфортности (по возрастанию):");
		for( int i=0; i<comfort.length; i++) {
			if(comfort[i]==0) {
				System.out.println("Общий вагон");
			}
			else if(comfort[i]==2) {
				System.out.println("Вагон первого класса");
			}
			else {
				System.out.println("Вагон второго класса");
			}
		}

		System.out.println();

	}
	public void Range() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Введите минимальное значение числа пассажиров для диапазона поиска подходящего вагона: ");
		int min=scan.nextInt();
		System.out.print("Введите максимальное значение числа пассажиров для диапазона поиска подходящего вагона: ");
		int max=scan.nextInt();
		int firstClassCarriage=18;
		int secondClassCarriage=36;
		int general=81;

		if(min<=firstClassCarriage && max<=firstClassCarriage ) {
			System.out.println("Данный диапазон соответствует вагоном типа: Вагон первого класса");
		}
		if(min<=secondClassCarriage && max<=secondClassCarriage) {
			System.out.println("Данный диапазон соответствует вагоном типа: Вагон второго класса");
		}

		if(min<=general && max<=general ) {
			System.out.println("Данный диапазон соответствует вагоном типа: Общий");
		}

		else {
			System.out.println("Для данного диапазона не найдено соответствий");
		}
	}

}