import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AVL implements TreeInterface {
    private NodeAVLProgramaNetflix root;

    public AVL() {
        root = null;
    }

    @Override
    public void insert(ProgramaNetflix programa) {
        root = insert(root, programa);
    }

    private NodeAVLProgramaNetflix insert(NodeAVLProgramaNetflix node, ProgramaNetflix programa) {
        if (node == null) {
            return new NodeAVLProgramaNetflix(programa);
        }

        if (programa.getTitulo().compareToIgnoreCase(node.getTitulo()) < 0) {
            node.left = insert(node.left, programa);
        } else if (programa.getTitulo().compareToIgnoreCase(node.getTitulo()) > 0) {
            node.right = insert(node.right, programa);
        } else {
            return node;
        }

        node.updateHeight();
        return balance(node, programa.getTitulo());
    }

    public void remove(String titulo) {
        root = remove(root, titulo);
    }

    private NodeAVLProgramaNetflix remove(NodeAVLProgramaNetflix node, String titulo) {
        if (node == null) {
            return null;
        }

        if (titulo.compareToIgnoreCase(node.getTitulo()) < 0) {
            node.left = remove(node.left, titulo);
        } else if (titulo.compareToIgnoreCase(node.getTitulo()) > 0) {
            node.right = remove(node.right, titulo);
        } else {
            if ((node.left == null) || (node.right == null)) {
                NodeAVLProgramaNetflix temp = node.left != null ? node.left : node.right;

                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                NodeAVLProgramaNetflix temp = minValueNode(node.right);
                node.copyData(temp);
                node.right = remove(node.right, temp.getTitulo());
            }
        }

        if (node == null) {
            return node;
        }

        node.updateHeight();
        return balance(node, titulo);
    }

    private NodeAVLProgramaNetflix balance(NodeAVLProgramaNetflix node, String titulo) {
        int balance = node.getBalanceFactor();

        if (balance > 1 && titulo.compareToIgnoreCase(node.left.getTitulo()) < 0) {
            return node.rightRotate();
        }

        if (balance < -1 && titulo.compareToIgnoreCase(node.right.getTitulo()) > 0) {
            return node.leftRotate();
        }

        if (balance > 1 && titulo.compareToIgnoreCase(node.left.getTitulo()) > 0) {
            node.left = node.left.leftRotate();
            return node.rightRotate();
        }

        if (balance < -1 && titulo.compareToIgnoreCase(node.right.getTitulo()) < 0) {
            node.right = node.right.rightRotate();
            return node.leftRotate();
        }

        return node;
    }

    private NodeAVLProgramaNetflix minValueNode(NodeAVLProgramaNetflix node) {
        NodeAVLProgramaNetflix current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
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

    private void collectDataInOrder(NodeAVLProgramaNetflix node, List<String> lines) {
        if (node == null)
            return;

        collectDataInOrder(node.left, lines);

        String csvLine = String.format("%s,%s,%s,\"%s\",%d,%s,%d,\"%s\",\"%s\",%d,%s,%.2f,%d,%.2f,%.2f",
                node.getId(), node.getTitulo(), node.getTipo().toString(), node.getDescricao(),
                node.getAnoLancamento(), node.getClassificacaoIndicativa(), node.getDuracao(),
                node.getGenero(), node.getPaisOrigem(), node.getTemporadas(), node.getImdbId(),
                node.getImdbScore(), node.getImdbVotes(), node.getTmdbPopularity(),
                node.getTmdbScore());
        lines.add(csvLine);

        collectDataInOrder(node.right, lines);
    }
}
