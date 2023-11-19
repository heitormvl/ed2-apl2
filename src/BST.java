import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BST {
    // Raiz da árvore de busca binária
    private NodeBSTProgramaNetflix root;

    // Construtor da classe BST
    public BST() {
        root = null; // Inicializa a árvore como vazia
    }

    // Método para inserir um novo programa na árvore
    public void insert(ProgramaNetflix programa) {
        if (root == null) {
            root = new NodeBSTProgramaNetflix(programa); // Cria um novo nó se a árvore estiver vazia
        } else {
            root.insert(programa); // Caso contrário, delega a inserção ao nó raiz
        }
    }

    // Método para remover um programa pelo id
    public void remove(String id) {
        if (root != null) {
            root = root.remove(id); // Remove o nó com o id especificado se a árvore não estiver vazia
        }
    }

    // Métodos para imprimir a árvore em diferentes ordens
    public void printInOrder() {
        if (root != null) {
            root.printInOrder(); // Imprime a árvore em ordem se não estiver vazia
        }
    }

    public void printPreOrder() {
        if (root != null) {
            root.printPreOrder(); // Imprime a árvore em pré-ordem se não estiver vazia
        }
    }

    public void printPostOrder() {
        if (root != null) {
            root.printPostOrder(); // Imprime a árvore em pós-ordem se não estiver vazia
        }
    }

    // Método para exportar dados para um arquivo CSV
    public void exportCsv(String filePath) {
        List<String> lines = new ArrayList<>();
        collectDataInOrder(root, lines);

        try (FileWriter writer = new FileWriter(filePath)) {
            // Escrever cabeçalho do CSV
            writer.write(
                    "ID,Titulo,Tipo,Descricao,AnoLancamento,ClassificacaoIndicativa,Duracao,Genero,PaisOrigem,Temporadas,ImdbID,ImdbScore,ImdbVotes,TmdbPopularity,TmdbScore\n");

            // Escrever os dados
            for (String line : lines) {
                writer.write(line);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void collectDataInOrder(NodeBSTProgramaNetflix node, List<String> lines) {
        if (node == null)
            return;

        collectDataInOrder(node.getLeft(), lines);

        // Converter os dados do programa para formato CSV
        ProgramaNetflix programa = node.getPrograma(); // Supondo que existe um método getPrograma
        String csvLine = String.format("%s,%s,%s,\"%s\",%d,%s,%d,\"%s\",\"%s\",%d,%s,%.2f,%d,%.2f,%.2f",
                programa.getId(), programa.getTitulo(), programa.getTipo().toString(), programa.getDescricao(),
                programa.getAnoLancamento(), programa.getClassificacaoIndicativa(), programa.getDuracao(),
                programa.getGenero(), programa.getPaisOrigem(), programa.getTemporadas(), programa.getImdbId(),
                programa.getImdbScore(), programa.getImdbVotes(), programa.getTmdbPopularity(),
                programa.getTmdbScore());
        lines.add(csvLine);

        collectDataInOrder(node.getRight(), lines);
    }

}
