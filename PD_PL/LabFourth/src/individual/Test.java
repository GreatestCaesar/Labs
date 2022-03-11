package individual;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int num_films;
        String name = "";
        ArrayList<Film> films;
        ArrayList<Actor> actors;
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        FilmDAO filmDAO = mysqlFactory.getFilmDAO();
        ActorDAO actorDAO = mysqlFactory.getActorDAO();
        films = filmDAO.outputFilm();
        for(Film f : films) {
            System.out.println(f);
        }
        System.out.println("\n\n");
        /*System.out.println("Введите количество лет: ");                                                               // удаление
        n = scanner.nextInt();
        System.out.println("Операция завершена: " + filmDAO.delete(n));*/
        System.out.println("\n\n");
        System.out.println("Введите название фильма, об актёрах которого хотите узнать информацию: ");
        scanner.nextLine();
        name = scanner.nextLine();
        actors = actorDAO.outputANF(name);
        for(Actor a : actors){
            System.out.println(a);
        }
        System.out.println("\n\n");
        System.out.println("Введите количество фильмов: ");
        num_films = scanner.nextInt();
        actors = actorDAO.outputAQF(num_films);
        for(Actor a : actors){
            System.out.println(a);
        }
        System.out.println("\n\n");
        actors = actorDAO.outputADF();
        for(Actor a : actors){
            System.out.println(a);
        }
    }
}
