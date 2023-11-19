import java.util.Scanner;

public class App {

    // Enumeração Tipo (ajuste conforme necessário)
    public enum Tipo {
        SHOW, MOVIE // Exemplo de valores para a enumeração
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        TreeInterface bst = new BST();
        TreeInterface avl = new AVL();

        do {
            opcao = mostrarMenu(scanner);

            // Processando a escolha do usuário
            switch (opcao) {
                case 1:
                    // Chamar método de leitura de dados
                    lerDadosArquivo(scanner, bst, avl);
                    System.out.println("Dados lidos com sucesso!");
                    break;
                case 2:
                    // Chamar método de análise de dados 1
                    break;
                // Incluir casos para cada opção do menu
                case 12:
                    System.out.println("Encerrando a aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 12);

        scanner.close();
    }

    private static int mostrarMenu(Scanner scanner) {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Ler dados de arquivo");
        System.out.println("2 - [Descrição da Análise de Dados 1]");
        // Incluir as demais opções do menu
        System.out.println("12 - Encerrar a Aplicação");
        System.out.print("Opção: ");

        return scanner.nextInt();
    }

    // Métodos para cada funcionalidade do menu
    // Receber caminho do arquivo de entrada e inserir os dados nas árvores
    private static void lerDadosArquivo(Scanner scanner, TreeInterface bst, TreeInterface avl) {
        System.out.print("Digite o caminho do arquivo de entrada: ");
        String caminho = scanner.next();

        ImportAndInsert.importAndInsert(caminho, bst);
        ImportAndInsert.importAndInsert(caminho, avl);
    }
}
