import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Define o local como US para aceitar pontos em números decimais (ex: 7.5)
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("=== SISTEMA DE NOTAS ESCOLARES ===");

        // 1. Validação da quantidade de alunos
        int qtdAlunos = 0;
        do {
            System.out.println("Quantos alunos deseja cadastrar? (Mínimo 1): ");
            if (scanner.hasNextInt()) {
                qtdAlunos = scanner.nextInt();
                if (qtdAlunos < 1) {
                    System.out.println("Erro: A quantidade de alunos deve ser pelo menos 1.");
                }
            } else {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
                scanner.next(); // Limpa a entrada incorreta
            }
        } while (qtdAlunos < 1);

        //2.  Validação da quantidade de notas por aluno
        int qtdNotas = 0;
        do {
            System.out.println("Quantas notas serão registradas por aluno? (Mínimo 1): ");
            if (scanner.hasNextInt()) {
                qtdNotas = scanner.nextInt();
                if (qtdNotas < 1) {
                    System.out.println("Erro: A quantidade de notas deve ser pelo menos 1.");
                }
            }  else {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        } while (qtdNotas < 1);

        scanner.nextLine();

        // Armazenamento dos alunos em um vetor (array)
        Aluno[] alunos = new Aluno[qtdAlunos];

        // 3. Leitura dos dados de cada aluno
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.printf("\n--- Cadastro do Aluno %d ---\n", i + 1);
            System.out.print("Nome do aluno: ");
            String nome = scanner.nextLine();

            // Instanciação do objeto Aluno utilizando o construtor com parâmetros
            alunos[i] = new Aluno(nome, qtdNotas);

            // Leitura e validação das notas do aluno atual
            for (int j = 0; j < qtdNotas; j++) {
                double nota = -1;
                do {
                    System.out.printf("Digite a nota %d (0.0 a 10.0): ", j + 1);
                    if (scanner.hasNextDouble()) {
                        nota = scanner.nextDouble();
                        if (nota < 0.0 || nota > 10) {
                            System.out.println("Erro: A nota deve estar entre 0.0 e 10.0.");
                        }
                    } else {
                        System.out.println("Erro: Entrada inválida. Digite um número decimal (use ponto).");
                        scanner.next();
                    }
                } while (nota < 0.0 || nota > 10);

                // Armazena a nota validada no objeto Aluno
                alunos[i].setNotas(j, nota);
            }
            scanner.nextLine();  // Limpa o buffer após ler números
        }

        // 4. Exibição dos resultados finais
        System.out.println("\n=======================================");
        System.out.println("           BOLETIM ESCOLAR             ");
        System.out.println("=======================================");

        for (Aluno aluno : alunos) {
            System.out.printf("Aluno: %-15s | Notas: ", aluno.getNome());
            for (double nota : aluno.getNotas()) {
                System.out.printf("[%2.1f] ", nota);
            }
            System.out.printf("| Média: %2.2f\n", aluno.calcularMedia());
        }
        System.out.println("======================================");

        scanner.close();
    }
}
