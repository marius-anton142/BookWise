package main;
import model.*;
import service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = "Default";

        OperationService.initialize();

        while (true) {
            try {
                if (menu.equals("Default")) {
                    MenuService.menuDefault();
                } else if (menu.equals("Author")) {
                    MenuService.menuAuthor();
                } else if (menu.equals("About")) {
                    MenuService.menuAbout();
                } else if (menu.equals("Product")) {
                    MenuService.menuProduct();
                } else if (menu.equals("Reader")) {
                    MenuService.menuReader();
                }

                int option = MenuService.option();
                if (option == 0) {
                    if (!menu.equals("Default")) {
                        menu = "Default";
                    } else {
                        break;
                    }
                } else if (menu.equals("Default")) {
                    switch (option) {
                        case 1: {
                            menu = "Author";
                            break;
                        }
                        case 2: {
                            menu = "Reader";
                            break;
                        }
                        case 3: {
                            menu = "Product";
                            break;
                        }
                        case 4: {
                            menu = "About";
                            break;
                        }
                        default: {
                            System.out.println("Invalid option");
                            System.out.println("******************************");
                        }

                    }
                } else if (menu.equals("Author")) {
                    switch (option) {
                        case 1: {
                            OperationService.printAuthors();
                            break;
                        }
                        case 2: {
                            OperationService.printAuthorsNationality();
                            break;
                        }
                        case 3: {
                            OperationService.addAuthor();
                            break;
                        }
                        case 4: {
                            OperationService.printAwards();
                            break;
                        }
                        default: {
                            System.out.println("Invalid option");
                            System.out.println("******************************");
                        }
                    }
                } else if (menu.equals("About")) {
                    switch (option) {
                        case 1: {
                            OperationService.printSections();
                            break;
                        }
                        case 2: {
                            OperationService.printAuthors();
                            OperationService.printAwards();
                            OperationService.printSections();
                            OperationService.printBooks();
                            OperationService.printLightNovels();
                            OperationService.printGames();
                            OperationService.printReaders();
                            break;
                        }
                        default: {
                            System.out.println("Invalid option");
                            System.out.println("******************************");
                        }
                    }
                } else if (menu.equals("Product")) {
                    switch (option) {
                        case 1: {
                            OperationService.printProducts();
                            break;
                        }
                        case 2: {
                            OperationService.addProduct();
                            break;
                        }
                        case 3: {
                            OperationService.removeProduct();
                            break;
                        }
                        case 4: {
                            OperationService.printBooks();
                            break;
                        }
                        case 5: {
                            OperationService.printLightNovels();
                            break;
                        }
                        case 6: {
                            OperationService.printGames();
                            break;
                        }
                        default: {
                            System.out.println("Invalid option");
                            System.out.println("******************************");
                        }
                    }
                } else if (menu.equals("Reader")) {
                    switch (option) {
                        case 1: {
                            OperationService.printReaders();
                            break;
                        }
                        case 2: {
                            try {
                                OperationService.increaseReaderBudget();
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            } finally {
                                break;
                            }
                        }
                        case 3: {
                            OperationService.buyProduct();
                            break;
                        }
                        case 4: {
                            System.out.println("no.");
                            break;
                        }
                        default: {
                            System.out.println("Invalid option");
                            System.out.println("******************************");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }
}