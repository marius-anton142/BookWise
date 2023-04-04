package model;

public class Author extends Person implements Comparable<Author>{
    private String penName = "?", nationality = "?";
    private int awardsWon = 0;

    public Author() {

    }
    public Author(String firstName, String lastName, int age, int phone, String penName, String nationality, int awardsWon) {
        super(firstName, lastName, age, phone);
        this.penName = penName;
        this.nationality = nationality;
        this.awardsWon = awardsWon;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAwardsWon() {
        return awardsWon;
    }

    public void setAwardsWon(int awardsWon) {
        this.awardsWon = awardsWon;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPen Name = " + this.penName + "\nNationality = " + this.nationality + "\nAwards Won = " + this.awardsWon;
    }

    @Override
    public int compareTo(Author author) {
        if (this.awardsWon != author.getAwardsWon()) {
            return this.awardsWon - author.getAwardsWon();
        } else if (!this.getLastName().equals(author.getLastName())) {
            return this.getLastName().compareTo(author.getLastName());
        } else {
            return this.getFirstName().compareTo(author.getFirstName());
        }
    }
}
