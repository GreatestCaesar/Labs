package by.bsac.practical.definiton;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    //конструктор с параметрами
    public Person(String firstName, String middleName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        System.out.println("Person "+getFirstName()+" "+getMiddleName()+" "+getLastName() + " " + getAge()+" years old");
    }
    //конструктор без параметров
    public Person() {
        System.out.println("New Person without Fisrt Name, Middle Name, Last Name and Age was created");
    }


    /* переопределение метода для корректного приведения объекта
    Person к строке, используя значения firstName, middleName, lastName,
    age. Подсказка: Данный метод сгенерирован в среде разработки, в нашем
    случае Eclipse. При генерации методов средой разработки, необходимо
    проверять правильно ли сгенерирован метод */
    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", age=" + age + "]";
    }


    /* данный метод был переопределен для корректного формирования
    hashCode. Подсказка: Данный метод сгенерирован в среде разработки, в
    нашем случае Eclipse. При генерации методов средой разработки,
    необходимо проверять правильно ли сгенерирован метод */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
        return result;
    }


    /* метод equals переопределен для корректного сравнения объектов
    класса Person. В качестве атрибутов для сравнения выступают Имя,
    отчество, Фамилия, возраст. Также проверяется принадлежность
    передаваемого объекта obj к классу Person. Подсказка: Данный метод
    сгенерирован в среде разработки, в нашем случае Eclipse. При генерации
    методов средой разработки, необходимо проверять правильно ли
    сгенерирован метод */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (middleName == null) {
            if (other.middleName != null)
                return false;
        } else if (!middleName.equals(other.middleName))
            return false;
        return true;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
