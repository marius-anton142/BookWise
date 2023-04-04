package service;
import model.*;
import java.util.*;

import java.util.PriorityQueue;

public class OperationService {
    private static PriorityQueue<Author> authors = new PriorityQueue<Author>();
    private static List<Section> sections = new ArrayList<Section>();
    private static List<Product> products = new ArrayList<>();
    private static List<Reader> readers = new ArrayList<>();

    public static void initialize() {
        Author author1 = new Author("Hirohiko", "Araki", 62, 574885463, "Araki", "Japanese", 175);
        Author author2 = new Author("Visan", "Fabian", 25, 784532759, "Many", "Romanian", 15);
        Author author3 = new Author("Donda", "Mihaita", 20, 765749687, "Rage Mike", "Romanian", 26);
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);

        Section section1 = new Section("Science Fiction", 87);
        Section section2 = new Section("History", 35);
        Section section3 = new Section("Manga", 72);
        sections.add(section1);
        sections.add(section2);
        sections.add(section3);

        products.add(new Book("Enciclopedia Ciupercilor", 399, section1, author3, "Un ghid complet al culegatorului de ciuperci.", 1250, 3));
        products.add(new LightNovel("Jojo", 180, section3, author1, "The adventures of the Joestar bloodline.", 35, 80));
        products.add(new Game("Binding of Isaac", 250, section2, author2, "Windows", true));
        products.add(new Book("Math Notebook", 2, section2, author3, "Linear algebra and reality shifting.", 180, 1));
        products.add(new LightNovel("Attack on Titan", 599, section3, author3, "Because I was born into this world.", 2000, 64));
        products.add(new Game("Chess", 50, section1, author1, "Android", true));
        products.add(new Book("Emerald Tablet", 15, section2, author2, "A comprehensive guide to all things Latvian cuisine.", 1, 1));

        readers.add(new Reader("Ion", "Juice", 12, 785467290, 50, false));
        readers.add(new Reader("Cecilia", "Faina", 35, 785736590, 500, true));
        readers.add(new Reader("Sorin", "Corin", 5, 123456789, 1000001, true));
    }

    public static void printSections()
    {
        System.out.println("ALL SECTIONS");
        System.out.println("******************************");

        for(int i = 0; i < sections.size(); ++i)
        {
            System.out.println(sections.get(i));
            System.out.println("******************************");
        }
    }
    public static void printProducts()
    {
        System.out.println("ALL PRODUCTS");
        System.out.println("******************************");

        for(int i = 0; i < products.size(); ++i)
        {
            System.out.println(products.get(i));
            System.out.println("******************************");
        }
    }

    public static void printBooks()
    {
        System.out.println("ALL BOOKS");
        System.out.println("******************************");

        for(int i = 0; i < products.size(); ++i)
        {
            if (products.get(i) instanceof Book) {
                System.out.println(products.get(i));
                System.out.println("******************************");
            }
        }
    }
    public static void printLightNovels()
    {
        System.out.println("ALL LIGHT NOVELS");
        System.out.println("******************************");

        for(int i = 0; i < products.size(); ++i)
        {
            if (products.get(i) instanceof LightNovel) {
                System.out.println(products.get(i));
                System.out.println("******************************");
            }
        }
    }
    public static void printGames()
    {
        System.out.println("ALL GAMES");
        System.out.println("******************************");

        for(int i = 0; i < products.size(); ++i)
        {
            if (products.get(i) instanceof Game) {
                System.out.println(products.get(i));
                System.out.println("******************************");
            }
        }
    }

    public static void printReaders() {
        System.out.println("ALL READERS");
        System.out.println("******************************");

        for(int i = 0; i < readers.size(); ++i)
        {
            System.out.println(readers.get(i));
            System.out.println("******************************");
        }
    }
    public static void increaseReaderBudget() {
        String firstName;
        Scanner optionScanner = new Scanner(System.in);
        System.out.println("Reader first name =  ");
        firstName = optionScanner.nextLine();

        Reader readerToFind = new Reader();
        for(int i = 0; i < readers.size(); ++i)
        {
            if (firstName.equalsIgnoreCase(readers.get(i).getFirstName())) {
                readerToFind = readers.get(i);
            }
        }

        if (!firstName.equalsIgnoreCase(readerToFind.getFirstName())) {
            System.out.println("Reader " + firstName + " not found.");
            return;
        }

        int extra;
        System.out.println("Money to be added = ");
        extra = Integer.parseInt(optionScanner.nextLine());
        if (extra < 0) {
            throw new IllegalArgumentException("Cannot add negative amount of money");
        } else {
            readerToFind.setBudget(readerToFind.getBudget() + extra);
            System.out.println(firstName + "'s budget has been changed to " + readerToFind.getBudget() + " lei.");
        }
    }

    public static void buyProduct() {
        String firstName;
        Scanner optionScanner = new Scanner(System.in);
        System.out.println("Reader first name =  ");
        firstName = optionScanner.nextLine();

        Reader readerToFind = new Reader();
        for(int i = 0; i < readers.size(); ++i)
        {
            if (firstName.equalsIgnoreCase(readers.get(i).getFirstName())) {
                readerToFind = readers.get(i);
            }
        }

        if (!firstName.equalsIgnoreCase(readerToFind.getFirstName())) {
            System.out.println("Reader " + firstName + " not found.");
            return;
        }

        String name;
        System.out.println("Product name to be bought =  ");
        name = optionScanner.nextLine();

        for(int i = 0; i < products.size(); ++i)
        {
            if (name.equalsIgnoreCase(products.get(i).getName())) {
                if (products.get(i).getPrice() > readerToFind.getBudget()) {
                    System.out.println("Reader " + readerToFind.getFirstName() + " needs " + (products.get(i).getPrice() - readerToFind.getBudget()) + " more lei in order to buy " + products.get(i).getName());
                    return;
                } else {
                    readerToFind.setBudget(readerToFind.getBudget() - products.get(i).getPrice());
                    System.out.println("Reader " + readerToFind.getFirstName() + " has bought a copy of " + products.get(i).getName() + " for " + products.get(i).getPrice() + " lei. " + readerToFind.getBudget() + " lei remaining.");

                    return;
                }
            }
        }
        System.out.println("Product " + name + " not found.");
    }

    public static void addProduct()
    {
        String type, name;
        int price;
        String authorFirstName = "";
        String sectionTitle = "";

        Scanner optionScanner = new Scanner(System.in);

        System.out.println("Type (Book/LightNovel/Game) =  ");
        type = optionScanner.nextLine();

        while (!type.equalsIgnoreCase("Book") && !type.equalsIgnoreCase("LightNovel") && !type.equalsIgnoreCase("Game")) {
            System.out.println("Please enter a valid product type");
            System.out.println("Type (Book/LightNovel/Game) =  ");
            type = optionScanner.nextLine();
        }
        System.out.println("Name =  ");
        name = optionScanner.nextLine();
        System.out.println("Price = ");
        price = Integer.parseInt(optionScanner.nextLine());

        System.out.println("Section title =  ");
        sectionTitle = optionScanner.nextLine();

        Section sectionToFind = new Section();
        for(int i = 0; i < sections.size(); ++i)
        {
            if (sectionTitle.equalsIgnoreCase(sections.get(i).getTitle())) {
                sectionToFind = sections.get(i);
            }
        }
        while (!sectionTitle.equalsIgnoreCase(sectionToFind.getTitle())) {
            System.out.println("Section " + sectionTitle + " doesn't exist. Reenter the title.");
            System.out.println("Section title =  ");
            sectionTitle = optionScanner.nextLine();

            for(int i = 0; i < sections.size(); ++i)
            {
                if (sectionTitle.equalsIgnoreCase(sections.get(i).getTitle())) {
                    sectionToFind = sections.get(i);
                }
            }
        }

        System.out.println("Author first name =  ");
        authorFirstName = optionScanner.nextLine();

        PriorityQueue<Author> authorsOrdered = new PriorityQueue<Author>();
        int authorsSize = authors.size();

        Author authorToFind = new Author();
        for (int i = 0; i < authorsSize; ++i) {
            Author authorTemp = new Author();
            authorTemp = authors.poll();
            if (authorTemp.getFirstName().equalsIgnoreCase(authorFirstName)) {
                authorToFind = authorTemp;
            }
            authorsOrdered.add(authorTemp);
        }
        for (int i = 0; i < authorsSize; ++i) {
            authors.add(authorsOrdered.poll());
        }

        while (!authorFirstName.equalsIgnoreCase(authorToFind.getFirstName())) {
            System.out.println("Author " + authorFirstName + " doesn't exist. Reenter the first name.");
            System.out.println("Author first name =  ");
            authorFirstName = optionScanner.nextLine();
            for (int i = 0; i < authorsSize; ++i) {
                Author authorTemp = new Author();
                authorTemp = authors.poll();
                if (authorTemp.getFirstName().equalsIgnoreCase(authorFirstName)) {
                    authorToFind = authorTemp;
                }
                authorsOrdered.add(authorTemp);
            }
            for (int i = 0; i < authorsSize; ++i) {
                authors.add(authorsOrdered.poll());
            }
        }

        if (type.equalsIgnoreCase("Book")) {
            String description;
            int pages, edition;

            System.out.println("Description =  ");
            description = optionScanner.nextLine();
            System.out.println("Number of pages = ");
            pages = Integer.parseInt(optionScanner.nextLine());
            System.out.println("Edition = ");
            edition = Integer.parseInt(optionScanner.nextLine());

            products.add(new Book(name, price, sectionToFind, authorToFind, description, pages, edition));
        } else if (type.equalsIgnoreCase("LightNovel")) {
            String artist;
            int pages, volumes;

            System.out.println("Artist =  ");
            artist = optionScanner.nextLine();
            System.out.println("Number of pages = ");
            pages = Integer.parseInt(optionScanner.nextLine());
            System.out.println("Volumes = ");
            volumes = Integer.parseInt(optionScanner.nextLine());

            products.add(new LightNovel(name, price, sectionToFind, authorToFind, artist, pages, volumes));
        } else if (type.equalsIgnoreCase("Game")) {
            String platform;
            boolean multiplayerSupport;

            System.out.println("Platform =  ");
            platform = optionScanner.nextLine();
            System.out.println("multiplayer support (true/false) = ");
            multiplayerSupport = optionScanner.nextBoolean();

            products.add(new Game(name, price, sectionToFind, authorToFind, platform, multiplayerSupport));
        }
    }
    public static void removeProduct()
    {
        String name;
        Scanner optionScanner = new Scanner(System.in);

        System.out.println("name =  ");
        name = optionScanner.nextLine();

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getName().equalsIgnoreCase(name)) {
                products.remove(i);
                System.out.println("Product " + name + " removed.");
                System.out.println("******************************");
                return;
            }
        }

        System.out.println("Product " + name + " not found.");
        System.out.println("******************************");
    }
    public static void printAuthors() {
        System.out.println("ALL AUTHORS");
        System.out.println("******************************");

        PriorityQueue<Author> authorsOrdered = new PriorityQueue<Author>();
        int authorsSize = authors.size();
        for (int i = 0; i < authorsSize; ++i) {
            Author authorTemp = new Author();
            authorTemp = authors.poll();
            System.out.println(authorTemp);
            System.out.println("******************************");
            authorsOrdered.add(authorTemp);
        }
        for (int i = 0; i < authorsSize; ++i) {
            authors.add(authorsOrdered.poll());
        }
        System.out.println(authorsSize + " authors found.");
        System.out.println("******************************");
    }
    public static void printAwards() {
        System.out.println("******************************");

        PriorityQueue<Author> authorsOrdered = new PriorityQueue<Author>();
        int authorsSize = authors.size();
        int totalAwards = 0;
        for (int i = 0; i < authorsSize; ++i) {
            Author authorTemp = new Author();
            authorTemp = authors.poll();
            authorsOrdered.add(authorTemp);

            totalAwards += authorTemp.getAwardsWon();
        }
        for (int i = 0; i < authorsSize; ++i) {
            authors.add(authorsOrdered.poll());
        }
        System.out.println("Total awards = " + totalAwards);
        System.out.println("******************************");
    }

    public static void printAuthorsNationality() {
        System.out.println("Nationality = ");
        Scanner optionScanner = new Scanner(System.in);
        String nationality = optionScanner.nextLine();

        System.out.println("All " + nationality + " authors");
        System.out.println("******************************");

        boolean found = false;
        int authorsNumber = 0;
        PriorityQueue<Author> authorsOrdered = new PriorityQueue<Author>();
        int authorsSize = authors.size();
        for (int i = 0; i < authorsSize; ++i) {
            Author authorTemp = new Author();
            authorTemp = authors.poll();
            if (authorTemp.getNationality().equalsIgnoreCase(nationality)) {
                System.out.println(authorTemp);
                System.out.println("******************************");
                found = true;
                ++authorsNumber;
            }
            authorsOrdered.add(authorTemp);
        }
        for (int i = 0; i < authorsSize; ++i) {
            authors.add(authorsOrdered.poll());
        }
        if (found == false) {
            System.out.println("No " + nationality + " authors found.");
            System.out.println("******************************");
        } else {
            System.out.println(authorsNumber + " authors found.");
            System.out.println("******************************");
        }
    }

    public static void addAuthor()
    {
        String firstName, lastName, penName, nationality;
        int age, phone, awardsWon;
        Scanner optionScanner = new Scanner(System.in);

        System.out.println("First Name =  ");
        firstName = optionScanner.nextLine();
        System.out.println("Last Name =  ");
        lastName = optionScanner.nextLine();
        System.out.println("Age = ");
        age = Integer.parseInt(optionScanner.nextLine());
        System.out.println("Phone Number = ");
        phone = Integer.parseInt(optionScanner.nextLine());
        System.out.println("Pen Name =  ");
        penName = optionScanner.nextLine();
        System.out.println("Nationality =  ");
        nationality = optionScanner.nextLine();
        System.out.println("Awards Won = ");
        awardsWon = Integer.parseInt(optionScanner.nextLine());

        authors.add(new Author(firstName, lastName, age, phone, penName, nationality, awardsWon));
        System.out.println("Author " + firstName + " " + lastName + " has been added to the Author List.");
    }
}
