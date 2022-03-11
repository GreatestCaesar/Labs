package by.bsac.lab3.individual;

class Link
{
    public String ind; // Данные
    public int data;
    public Link next; // Следующий элемент в списке
    // -------------------------------------------------------------
    public Link(String ind, int data) // Конструктор
    {
        this.ind = ind;
        this.data = data;
    }
    // -------------------------------------------------------------
    public void displayLink() // Вывод содержимого элемента
    { System.out.print(ind + " " + data); }

    public void specialDisplay(){
        System.out.print(data);
    }
// -------------------------------------------------------------
} // Конец класса Link
////////////////////////////////////////////////////////////////
