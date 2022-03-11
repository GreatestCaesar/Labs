package by.bsac.practical6.individual.Lots;

public class Lots {
    private Lot first;

    public void Lots(){
        first = null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertFirst(String name, String author, double price, int part)
    { // Создание нового элемента
        Lot newLink = new Lot(name,author,price,part);
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }

    public void insertFirst(Lot lot){
        Lot newLot = new Lot(lot);
        newLot.next = first; // newLink --> старое значение first
        first = newLot; // first --> newLink
    }

    public Lot getFirst(){
        return first;
    }

    public void displayFirst(){
        System.out.println("Лот: ");
        Lot current = first;
        current.displayLink();
        System.out.println();
    }

    public void displayList()
    {
        System.out.print("Лоты: ");
        Lot current = first; // От начала списка
        while(current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println("");
    }

    public Lot deleteFirst() // Удаление первого элемента
    { // (предполагается, что список не пуст)
        Lot temp = first; // Сохранение ссылки
        first = first.next; // Удаление: first-->ссылка на второй элемент
        return temp; // Метод возвращает ссылку
    }

    public int size(){
        int d=0;
        Lot current = first; // От начала списка
        while(current != null) // Перемещение до конца списка
        {
            d++;
            current = current.next;  // Вывод данны
        }
        return d;
    }

    public void newPriceLot(double n){
        Lot current = first;
        int price = (int) first.price;
        current.price = price+n;
    }

    public void setPart(int n){
        Lot current = first;
        current.part = n;
    }

    public void dropPart(){
        Lot current = first;
        current.part -= 1;
    }

    public int getPart(){
        Lot current = first;
        return current.part;
    }
}
