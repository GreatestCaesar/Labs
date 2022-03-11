package by.bsac.practical7.individual.Lab;

import by.bsac.practical7.individual.Create.Create;
import by.bsac.practical7.individual.Create.DataForPlanes;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Create.create();
        Create.createTables();
        DataForPlanes d = null;

        Airlinee air;
        PassengerPlane p1= new PassengerPlane();
        d.filling(p1);
        PassengerPlane p2= new PassengerPlane();
        d.filling(p2);
        PassengerPlane p3= new PassengerPlane();
        d.filling(p3);
        PassengerPlane p4= new PassengerPlane();
        d.filling(p4);
        PassengerPlane p5= new PassengerPlane();
        d.filling(p5);

        CargoPlane c1=new CargoPlane();
        d.filling(c1);
        CargoPlane c2=new CargoPlane();
        d.filling(c2);
        CargoPlane c3=new CargoPlane();
        d.filling(c3);

        Plane pl1=new Plane();
        d.filling(pl1);
        Plane pl2=new Plane();
        d.filling(pl2);

        System.out.println(p1.totalCapacity(p2,p3));

        p1.sort(p2,p3,p4,p5);
        System.out.println(p1.totalCapacity(p2,p3));
        System.out.println(c1.totalLiftCap(c2,c3));
        pl1.borders(pl2);
    }
}