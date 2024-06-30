import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Funcionario> list = new ArrayList<>();

        System.out.println();
        System.out.print("Quantos funcionários serão registrados ? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println();
            System.out.println("Funcionário #" + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            while (idExistente(list, id)) {
                System.out.println("Esse ID já existe, tente novamente: ");
                id = sc.nextInt();
            }
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Salário: ");
            Double salario = sc.nextDouble();
            System.out.println();

            Funcionario func = new Funcionario(id, nome, salario);
            list.add(func);
        }

        System.out.print("Digite o ID do funcionário que terá o salário aumentado: ");
        int idSalario = sc.nextInt();

        Integer pos = posicao(list, idSalario);

        while (pos == null) {
            System.out.println("Esse ID não existe, tente novamente: ");
            idSalario = sc.nextInt();
            pos = posicao(list, idSalario);
        }

        System.out.print("Digite a porcentagem: ");
        double percent = sc.nextDouble();
        list.get(pos).aumentarSalario(percent);

        System.out.println("Lista de funcionários: ");
        System.out.println();
        for (Funcionario funcio : list) {
            System.out.println(funcio);
        }

        sc.close();
    }

    public static Integer posicao(List<Funcionario> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }

    public static boolean idExistente(List<Funcionario> list, int id) {
        Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return func != null;
    }
}