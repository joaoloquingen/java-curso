import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a quantidade de linas da matriz: ");
        int m = sc.nextInt();
        System.out.print("Digite a quantidade de colunas da matriz: ");
        int n = sc.nextInt();

        int[][] mat = new int[m][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print("Digite o elemento da linha " + i + ", coluna " + j + ": ");
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println();
        System.out.println("Todos os elementos da matriz: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Digite o elemento que deseja procurar: ");
        int elemento = sc.nextInt();
        boolean achou = false;

        System.out.println();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (elemento == mat[i][j]) {
                    System.out.println("Ocorrência do elemento " + elemento + " na linha " + i + ", coluna " + j);
                    System.out.println();
                    if (j + 1 < mat[i].length) {
                        System.out.println("O elemento posicionado à direita do " + mat[i][j] + " é: " + mat[i][j + 1]);
                    }
                    if (j > 0) {
                        System.out.println("O elemento posicionado à esquerda do " + mat[i][j] + " é: " + mat[i][j - 1]);
                    }
                    if (i > 0) {
                        System.out.println("O elemento posicionado acima do " + mat[i][j] + " é: " + mat[i-1][j]);
                    }
                    if (i+1 < mat[i].length){
                        System.out.println("O elemento posicionado abaixo do " + mat[i][j] + " é: " + mat[i+1][j]);
                    }
                    System.out.println();
                    achou = true;
                }
            }
        }


        if (achou == false) {
            System.out.println("Não há ocorrência desse elemento na matriz.");
        }

        sc.close();
    }
}