package by.bsac.practical5.individual.Task4fromLab2.main;

import by.bsac.practical5.individual.Task4fromLab2.cargo.CargoPlane;
import by.bsac.practical5.individual.Task4fromLab2.exception.RangeException;
import by.bsac.practical5.individual.Task4fromLab2.passenger.PassengerPlane;
import by.bsac.practical5.individual.Task4fromLab2.planes.Plane;

public class Main {
	public static void main(String[] args) throws RangeException {

		PassengerPlane p1= new PassengerPlane(32, 450, 350);
		PassengerPlane p2= new PassengerPlane();
		PassengerPlane p3= new PassengerPlane();
		PassengerPlane p4= new PassengerPlane();
		PassengerPlane p5= new PassengerPlane();

		CargoPlane c1=new CargoPlane(55, 320, 500);
		CargoPlane c2=new CargoPlane();
		CargoPlane c3=new CargoPlane();

		Plane pl1=new Plane();
		Plane pl2=new Plane();

		Plane[] planes = new Plane[4];

		planes[0]=p1;
		planes[1]=c1;
		planes[2]= new Plane(28, 370);
		planes[3]= new Plane(37, 290);

		for(Plane p: planes) {
			System.out.println(p);
		}
		System.out.println("Отсортированный:");
		System.out.println("");
		p1.sort1(planes);
		p1.sort(p2,p3,p4,p5);
		System.out.println(p1.totalCapacity(p2,p3));																	// исключение будет здесь, когда попросит дальность для рассчёта общей вместимости введи 1500 и выйдет исключение.
																														// это как пример показать собственное исключение
																														// т.к. нет арифметически и подобных вычислений, то стандартные исключения необходимо
																														// если необходимо "отловить" исключение
		System.out.println(c1.totalLiftCap(c2,c3));																		// эту строку заключить в блок try { } catch(Exception e){System.out.println(e);} оно выведет сообщение ошибки с безопасным продолжение работы программы
		pl1.borders(pl2);

	}
}
