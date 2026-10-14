public class Aluno {
    // Atributos privados (Encapsulamento)
    private String nome;
    private double[] notas;

    // Construtor com parâmetros para inicializar o objeto
    public Aluno(String nome, int quantidadedeNotas) {
        this.nome = nome;
        this.notas = new double[quantidadedeNotas];
    }

    // Método_ para calcular a média a partir da coleção de notas
    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }

        // Evita a divisão por zero caso o array seja vazio
        return notas.length > 0 ? soma / notas.length : 0.0;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // PROTEÇÃO: Retorna uma cópia do array, impedindo alterações externas diretas
    public double[] getNotas() {
        return notas.clone();
    }

    // Permite definir uma nota em uma posição específica do vetor
    public void setNotas(int indice, double nota) {
        // 1. Valida se o índice existe no vetor
        if (indice < 0 || indice >= notas.length) {
            System.out.println("Erro: Índice inválido para o array de notas.");
            return;
        }

        // 2. Valida se a nota é válida (ex: entre 0.0 e 10.0)
        if (validarNota(nota)) {
            this.notas[indice] = nota;
        } else {
            System.out.println("Erro: A nota deve estar entre 0.0 e 10.0.");
        }
    }

    // Método_ privado auxiliar para garantir a integridade do dado
    private boolean validarNota(double nota) {
        return nota >= 0.0 && nota <= 10.0;
    }
}



