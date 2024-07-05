package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            sc.nextLine();
            if (ch == 'c'){
                products.add(new Product(name, price));
            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                sc.nextLine();
                products.add(new UsedProduct(name, price, date));
            } else if (ch == 'i') {
                System.out.print("Customs fee: ");
                double customfee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customfee));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product p: products){
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}