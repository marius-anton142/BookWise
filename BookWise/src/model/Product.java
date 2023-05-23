package model;

public abstract class Product {
    private String name;
    private int price;
    private Section section;
    private Author author;

    public Product() {

    }
    public Product(String name, int price, Section section, Author author) {
        this.name = name;
        this.price = price;
        this.section = section;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return ("Name = " + this.name + "\nprice = " + this.price + "lei\nSection = " + this.section.getTitle() + "\nAuthor = " + this.author.getFirstName() + " " + this.author.getLastName());
    }

    @Override
    public boolean equals(Object o)
    {
        return (this.getPrice() == (((Product)o).getPrice()));
    }
}
