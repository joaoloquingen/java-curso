package AlturaMedia;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serão digitadas ? ");
        int n = sc.nextInt();
        System.out.println();

        if (n == 0){
            System.out.println("Nenhuma instancia de pessoa criada, o programa será encerrado!");
            sc.close();
            return;
        }

        Pessoa[] vet = new Pessoa[n];

        for (int i = 0; i < n; i++) {
            vet[i] = new Pessoa();
            System.out.println("Dados da pessoa numero " + (i + 1) + ":");
            System.out.println();
            System.out.print("Digite o nome: ");
            vet[i].setNome(sc.next());
            System.out.print("Digite a idade: ");
            vet[i].setIdade(sc.nextInt());
            System.out.print("Digite a altura: ");
            vet[i].setAltura(sc.nextDouble());
            System.out.println();
        }

        /* imprimir todos os dados
         for (int i = 0; i < n; i++) {
            System.out.println("Nome da pessoa número " + (i + 1) + ": " + vet[i].getNome());
            System.out.println("Idade da pessoa número " + (i + 1) + ": " + vet[i].getIdade());
            System.out.println("Altura da pessoa número " + (i + 1) + ": " + String.format("%.2f",vet[i].getAltura()));
        } */

        StringBuilder nomes = new StringBuilder();
        for (int i = 0; i < n; i++) {
            nomes.append(vet[i].getNome());
            if (i < n - 2) {
                nomes.append(", ");
            } else if (i == n - 2) {
                nomes.append(" e ");
            }
        }

        double soma = 0.0;
        for (int i = 0; i < n; i++) {
            soma += vet[i].getAltura();
        }
        double mediaAltura = soma / n;

        if (n == 1) {
            System.out.print("Só temos os dados do(a) " + nomes.toString() + ", portanto a média da altura será de " + mediaAltura);
        } else if (n >= 2) {
            System.out.print("A media das alturas é de " + String.format("%.2f", +mediaAltura));
        }


        int contador = 0;
        for (int i = 0; i < n; i++) {
            if (vet[i].getIdade() < 16) {
                contador += 1;
            }
        }
        double porcentagem = 100.00 / n * contador;


        if (n == 1 & vet[0].getIdade() > 16) {
            System.out.print(" e ele(a) possui mais de " + vet[0].getIdade() + " anos de idade.");
        } else if (n == 1 & vet[0].getIdade() < 16) {
            System.out.print(" e ele(a) possui menos de " + vet[0].getIdade() + " anos de idade.");
        } else if (n == 1 & vet[0].getIdade() == 16) {
            System.out.print(" e ele(a) possui " + vet[0].getIdade() + " anos de idade.");
        } else if (n >= 2) {
            System.out.print(" e a porcentagem de idades abaixo dos 16 anos entre " + nomes.toString() + " é de "
                    + String.format("%.1f%%", porcentagem));
        }
        System.out.println();
        sc.close();
    }
}