package by.bsac.lab4.individual.DAO;

import by.bsac.lab4.individual.Objects.Galaxy;
import by.bsac.lab4.individual.Objects.Planet;

import java.util.ArrayList;

public interface SpaceDAO {
    void findLife(String galaxy);
    void countSattelites();
    void haveSattelites(int x);
    void radius();
}
