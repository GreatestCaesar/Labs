package example;

public class Student {
    private String name;
    private Integer personalNumber;
    private String groupNumber;
    private Integer course;
    // класс с информацией о студенте
    public Student(String name, Integer personalNumber, String groupNumber, int course) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.groupNumber = groupNumber;
        this.course = course;
        System.out.println("Created student " + getName() + " with personalId " + getPersonalNumber() + ", course " + getCourse() + ", group " + getGroupNumber());
    }

    public Student() {
        System.out.println("New student has been created");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGroupNumber() {
        return groupNumber;
    }
    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
    public Integer getCourse() {
        return course;
    }
    public void setCourse(Integer course) {
        this.course = course;
    }
    public void setPersonalNumber(Integer personalNumber) {
        this.personalNumber = personalNumber;
    }
    public int getPersonalNumber() {
        return personalNumber;
    }

    @Override
    public String toString() {
        return "Student " + getName() + ", personalId = " + getPersonalNumber() + ", course = " + getCourse() + ", group = " + getGroupNumber();
    }
}
