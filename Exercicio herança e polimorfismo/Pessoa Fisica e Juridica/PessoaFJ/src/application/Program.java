package application;

import entities.Contribuintes;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Contribuintes> contribuintes = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual income: ");
            double rendaAnual = sc.nextDouble();
            sc.nextLine();
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double gastosSaude = sc.nextDouble();
                contribuintes.add(new PessoaFisica(name, rendaAnual, gastosSaude));
            } else {
                System.out.print("Number of employees: ");
                int nFuncionarios = sc.nextInt();
                sc.nextLine();
                contribuintes.add(new PessoaJuridica(name, rendaAnual, nFuncionarios));
            }
        }

        double contador = 0.0;
        System.out.println("TAXES PAID: ");
        for (Contribuintes con : contribuintes) {
            System.out.printf("%s: $ %.2f", con.getNome(), con.impostos());
            System.out.println();

            contador += con.impostos();
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f", contador);

        sc.close();
    }
}