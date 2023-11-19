import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BST implements TreeInterface {
    private NodeBSTProgramaNetflix root;

    public BST() {
        root = null;
    }

    @Override
    public void insert(ProgramaNetflix programa) {
        root = insert(root, programa);
    }

    private NodeBSTProgramaNetflix insert(NodeBSTProgramaNetflix node, ProgramaNetflix programa) {
        if (node == null) {
            return new NodeBSTProgramaNetflix(programa);
        }

        if (programa.getId().compareToIgnoreCase(node.getPrograma().getId()) < 0) {
            node.setLeft(insert(node.getLeft(), programa));
        } else if (programa.getId().compareToIgnoreCase(node.getPrograma().getId()) > 0) {
            node.setRight(insert(node.getRight(), programa));
        }

        return node;
    }

    public void remove(String id) {
        if (root != null) {
            root = root.remove(id);
        }
    }

    public void printInOrder() {
        if (root != null) {
            root.printInOrder();
        }
    }

    public void printPreOrder() {
        if (root != null) {
            root.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (root != null) {
            root.printPostOrder();
        }
    }

    public void exportCsv(String filePath) {
        List<String> lines = new ArrayList<>();
        collectDataInOrder(root, lines);

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(
                    "ID,Titulo,Tipo,Descricao,AnoLancamento,ClassificacaoIndicativa,Duracao,Genero,PaisOrigem,Temporadas,ImdbID,ImdbScore,ImdbVotes,TmdbPopularity,TmdbScore\n");
            for (String line : lines) {
                writer.write(line);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void collectDataInOrder(NodeBSTProgramaNetflix node, List<String> lines) {
        if (node == null) {
            return;
        }

        collectDataInOrder(node.getLeft(), lines);

        ProgramaNetflix programa = node.getPrograma();
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
