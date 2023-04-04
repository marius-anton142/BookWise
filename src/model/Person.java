package model;

public abstract class Person {
    private String firstName, lastName;
    private int age, phone;

    public Person() {
        this.firstName = "?";
        this.lastName = "?";
        this.age = -1;
        this.phone = -1;
    }

    public Person(String firstName,String lastName, int age, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ("First Name = " + this.firstName + "\nLast Name = " + this.lastName + "\nAge = " + this.age + "\nPhone Number = " + this.phone);
    }
}
