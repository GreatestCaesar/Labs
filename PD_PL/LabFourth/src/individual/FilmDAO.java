package individual;

import java.util.ArrayList;

public interface FilmDAO {
    ArrayList<Film> outputFilm();
    boolean delete(int n);
}
