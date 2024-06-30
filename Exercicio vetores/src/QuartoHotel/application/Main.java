package QuartoHotel.application;

import QuartoHotel.entities.Aluguel;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Aluguel[] vetor = new Aluguel[10];

        System.out.print("Quantos quartos serão alugados ? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("Aluguel #" + i + ":");
            System.out.println("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.next();
            System.out.print("Quarto: ");
            int numeroQuarto = sc.nextInt();

            vetor[numeroQuarto] = new Aluguel(nome, email);
        }

        System.out.println();
        System.out.println("Quartos ocupados: ");
        for (int i = 1; i < 10; i++){
            if (vetor[i] != null){
                System.out.println(i + ": " + vetor[i]);
            }
        }
        sc.close();
    }
}
