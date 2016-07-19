package edu.pace.cs6392016.sophia.cs639firebase;

public class Student {

    private String id;
    private String firstName;

    public Student() {
        this.id = "0";
        this.firstName = "Foo";
    }

    public Student(String id, String firtName) {
        this.id = id;
        this.firstName = firtName;
    }

    public String getid() { return id;}

    public String getFirstName() {return firstName;}

    public void setId(String id) {this.id = id;}

    public void setFirstName(String firstName) { this.firstName = firstName;}
}
