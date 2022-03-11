package by.bsac.lab3.individual;

class FirstLastList
{
    private Link first; // Ссылка на первый элемент
    private Link last; // Ссылка на последний элемент
    // -------------------------------------------------------------
    public FirstLastList() // Конструктор
    {
        first = null; // Список пока не содержит элементов
        last = null;
    }
    // -------------------------------------------------------------
    public boolean isEmpty() // true, если список пуст
    { return first==null; }
    // -------------------------------------------------------------
    public void insertFirst(String ind, int data) // Вставка элемента в начало списка
    {
        Link newLink = new Link(ind,data); // Создание нового элемента
        if( isEmpty() ) // Если список пуст,
            last = newLink; // newLink <-- last
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }
    // -------------------------------------------------------------
    public void insertLast(String ind, int data) // Вставка элемента в конец списка
    {
        Link newLink = new Link(ind,data); // Создание нового элемента
        if( isEmpty() ) // Если список пуст,
            first = newLink; // first --> newLink
        else
            last.next = newLink; // Старое значение last --> newLink
            last = newLink; // newLink <-- last
    }
    // -------------------------------------------------------------
    public void deleteFirst() // Удаление первого элемента списка
    { // (предполагается, что список не пуст)
        if(first.next == null) // Если только один элемент
            last = null; // null <-- last
        first = first.next; // first --> старое значение next
    }
    // -------------------------------------------------------------
    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first; // От начала списка
        while(current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            System.out.println();
            current = current.next; // Переход к следующему элементу
        }
        System.out.println("");
    }
    public Link find(String key) // Поиск элемента с заданным ключом
    { // (предполагается, что список не пуст)
        Link current = first; // Начиная с 'first'
        while(!current.ind.equals(key)) // Пока совпадение не найдено
        {
            if(current.next == null) // Если достигнут конец списка
                return null; // и совпадение не найдено
            else // Если еще остались элементы
                current = current.next; // Перейти к следующему элементу
        }
        return current; // Совпадение обнаружено
    }
    public void specialDisplay(){
        Link current = first;
        int k=0;
        while(current != null) // Перемещение до конца списка
        {
            current.specialDisplay(); // Вывод данных
            System.out.print(" ");
            current = current.next; // Переход к следующему элементу
            k++;
            if(k == 5 ){
                System.out.println();
                k=0;
            }
        }
    }
// -------------------------------------------------------------
} // Конец класса FirstLastList
