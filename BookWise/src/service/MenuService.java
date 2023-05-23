package service;
import main.Main;

import java.util.Scanner;

public class MenuService {
    public static int option() {
        Scanner optionScanner = new Scanner(System.in);
        int option = Integer.parseInt(optionScanner.nextLine());
        return option;
    }

    public static void menuDefault() {
        System.out.println("♣Welcome to BookWise!♣");
        System.out.println("1.About authors");
        System.out.println("2.About readers");
        System.out.println("3.Manage products");
        System.out.println("4.About us");
        System.out.println("0.Exit");
        System.out.println("==============================");
    }
    public static void menuAuthor() {
        System.out.println("About Authors");
        System.out.println("1.Show authors");
        System.out.println("2.Show authors by nationality");
        System.out.println("3.Add author");
        System.out.println("4.Show total number of awards won by all authors");
        System.out.println("0.Back");
        System.out.println("==============================");
    }
    public static void menuAbout() {
        System.out.println("About Us");
        System.out.println("1.Show sections");
        System.out.println("2.Show everything");
        System.out.println("0.Back");
        System.out.println("==============================");
    }

    public static void menuProduct() {
        System.out.println("Manage Products");
        System.out.println("1.Show products");
        System.out.println("2.Add product");
        System.out.println("3.Remove product");
        System.out.println("4.Show books");
        System.out.println("5.Show light novels");
        System.out.println("6.Show games");
        System.out.println("0.Back");
        System.out.println("==============================");
    }

    public static void menuReader() {
        System.out.println("About Readers");
        System.out.println("1.Show readers");
        System.out.println("2.Increase reader budget");
        System.out.println("3.Buy a copy of a product");
        System.out.println("4.AM I RICH???");
        System.out.println("0.Back");
        System.out.println("==============================");
    }
}
