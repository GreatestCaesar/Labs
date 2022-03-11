package by.bsac.practical.run;

import by.bsac.practical.definiton.Person;
import by.bsac.practical.definiton.Student;

class Practical3Runner {
    public static void main(String[] args) {
        Person personEn = new Person();
        personEn.setFirstName("John");
        personEn.setLastName("Smith");
        personEn.setAge(19);
        System.out.println(personEn);
        Person personRu1 = new Person("Иван", "Иванович", "Иванов", 20);
        System.out.println(personRu1);
        Person personRu2 = new Person("Иван", "Иванович", "Иванов", 20);
        System.out.println("personRu1 == personRu2 ? " + personRu1.equals(personRu2));
        System.out.println("person1 hashcode " + personRu1.hashCode() + " person2 hashcode" + personRu2.hashCode());
        Student student = new Student("Виктор", "Михайлович", "Селезнев", 20, "СП999", 19);
        System.out.println("student.toString()=" + student);
        Student student1 = new Student("Дмитрий", "Иванович", "Попков", 20, "СП999", 18);
        System.out.println("student == student1 ? " + student.equals(student1));
    }
}
