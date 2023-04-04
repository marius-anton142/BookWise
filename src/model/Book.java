package model;

public class Book extends Product {
    private String description;
    private int pages, edition;

    public Book() {

    }

    public Book(String name, int price, Section section, Author author, String description, int pages, int edition) {
        super(name, price, section, author);
        this.description = description;
        this.pages = pages;
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString()
    {
        return (super.toString() + "\nDescription = " + this.description + "\nNumber of pages = " + this.pages + "\nEdition = " + this.edition);
    }
}
