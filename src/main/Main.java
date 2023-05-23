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
                            AuditService.log("printAuthors");
                            break;
                        }
                        case 2: {
                            OperationService.printAuthorsNationality();
                            AuditService.log("printAuthorsNationality");
                            break;
                        }
                        case 3: {
                            OperationService.addAuthor();
                            AuditService.log("addAuthor");
                            break;
                        }
                        case 4: {
                            OperationService.printAwards();
                            AuditService.log("printAwards");
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
                            AuditService.log("printSections");
                            break;
                        }
                        case 2: {
                            AuditService.log("printAll");
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
                            AuditService.log("printProducts");
                            OperationService.printProducts();
                            break;
                        }
                        case 2: {
                            AuditService.log("addProduct");
                            OperationService.addProduct();
                            break;
                        }
                        case 3: {
                            AuditService.log("removeProduct");
                            OperationService.removeProduct();
                            break;
                        }
                        case 4: {
                            AuditService.log("printBooks");
                            OperationService.printBooks();
                            break;
                        }
                        case 5: {
                            OperationService.printLightNovels();
                            AuditService.log("printLightNovels");
                            break;
                        }
                        case 6: {
                            OperationService.printGames();
                            AuditService.log("printNovels");
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
                            AuditService.log("printReaders");
                            OperationService.printReaders();
                            break;
                        }
                        case 2: {
                            try {
                                OperationService.increaseReaderBudget();
                                AuditService.log("increaseReaderBudget");
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            } finally {
                                break;
                            }
                        }
                        case 3: {
                            OperationService.buyProduct();
                            AuditService.log("buyProduct");
                            break;
                        }
                        case 4: {
                            System.out.println("no.");
                            AuditService.log("areYouRich?");
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
