package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o tamanho da matriz: ");
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.printf("Digite o elemento [%d][%d]: ", i, j);
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println();
        System.out.println("Todos os elementos da matriz: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.printf("%d ", mat[i][j]);
            }
            System.out.println();
        }

        // int ultimo = mat[n-1] [n-1];
        System.out.println();
        System.out.println("Elementos na diagonal da matriz: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i == j) {
                    for (int k = 0; k < i; k++) {
                        System.out.print("  ");
                    }
                    System.out.println(mat[i][j]);
                }
            }
        }

        int cont = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] < 0) {
                    cont += 1;
                }
            }
        }

        System.out.println();
        System.out.println("A quantidade de números negativos é: " + cont);
        sc.close();
    }
}