package by.bsac.practical6.individual.Lots;

public class Lot {
    public String name; // название
    public String author; // автор
    public double price; // цена
    public int part; // кол-во участников, которые голосуют за лот
    public Lot next; // Следующий элемент в списке
    // -------------------------------------------------------------
    public Lot(String n, String a, double p, int part) // Конструктор
    {
        name = n; // Инициализация данных
        price = p; // (‘next’ автоматически
        author = a;
        this.part = part;
    }               // присваивается null)

    public Lot(Lot lot){
        this.name = lot.name;
        this.price = lot.price;
        this.author = lot.author;
        this.part = 0;
    }
    // -------------------------------------------------------------
    public void displayLink() // Вывод содержимого элемента
    {
        System.out.print("*!*\nНазвание: " + name + "\n\tАвтор: " + author + "\n\t\tЦена: " + price + "$ \n*!* \n\n");
    }
}
