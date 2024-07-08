package application;

import entities.Account;
import exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        Double balance = sc.nextDouble();
        sc.nextLine();
        System.out.print("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();
        sc.nextLine();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        Double amount = sc.nextDouble();

        try {
            acc.withdraw(amount);
            System.out.print("New balance: " + acc.getBalance());
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}