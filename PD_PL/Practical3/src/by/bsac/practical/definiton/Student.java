package by.bsac.practical.definiton;

public class Student extends Person {
    private int id;
    private String groupNumber;

    public Student() {
        System.out.println("Creating new student with undefined Fist Name, Second Name, Middle Name, Age and Group Number");
    }
    public Student(String firstName, String middleName, String lastName, int age, String groupNumber, int id){
        super(firstName, middleName, lastName, age);
        this.id = id;
        this.groupNumber = groupNumber;
        System.out.println("Creating new student with FistName:"+getFirstName()+", Middle Name="+getMiddleName()+", " +" Last Name="+getLastName() + " Group Number="+getGroupNumber()+ " id=" + getId());
    }

    //Создайте дополнительные варианты конструкторов,
    //которые будут инициализировать оставшиеся члены класса(member variables)
    @Override
    public String toString() {
        return "Student [id=" + id + ", groupNumber=" + groupNumber + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getMiddleName()=" + getMiddleName() + ", getAge()=" + getAge() + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((groupNumber == null) ? 0 :
                groupNumber.hashCode());
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Student))
            return false;
        Student other = (Student) obj;
        if (groupNumber == null) {
            if (other.groupNumber != null)
                return false;
        } else if (!groupNumber.equals(other.groupNumber))
            return false;
        if (id != other.id)
            return false;
        return true;
    }


    public String getGroupNumber() {
        return groupNumber;
    }
    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
