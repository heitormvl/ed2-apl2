
public class App {

    // Enumeração Tipo (ajuste conforme necessário)
    public enum Tipo {
        SHOW, MOVIE // Exemplo de valores para a enumeração
    }

    // Main

    public static void main(String[] args) {
        TreeInterface bst = new BST();

        // Importar e inserir os programas
        ImportAndInsert.importAndInsert("C:\\Users\\heito\\Downloads\\archive\\titles.csv", bst);

        // Gerar o arquivo CSV da BST
        bst.exportCsv("C:\\Users\\heito\\Downloads\\exported_titles.csv");

        TreeInterface avl = new AVL();

        // Importar e inserir os programas
        ImportAndInsert.importAndInsert("C:\\Users\\heito\\Downloads\\archive\\titles.csv", avl);

        // Gerar o arquivo CSV da AVL
        avl.exportCsv("C:\\Users\\heito\\Downloads\\exported_titles_avl.csv");
    }
}
