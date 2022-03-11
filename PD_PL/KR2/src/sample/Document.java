package sample;

import java.util.Date;

public class Document {
    private int id;
    private String name;
    private String department;
    private String responsible;
    private String type;
    private String date;

    public Document() {
    }

    public Document(int id, String name, String department, String responsible, String type, String date) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.responsible = responsible;
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", responsible='" + responsible + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
