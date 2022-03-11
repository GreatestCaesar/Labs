package individual;

import java.util.ArrayList;

public interface ActorDAO {
    public ArrayList<Actor> outputANF(String film); // по названию фильма
    public ArrayList<Actor> outputAQF(int n); // по кол-ву фильмов
    public ArrayList<Actor> outputADF(); // если актер был режиссером хоть одного из фильмов
}
