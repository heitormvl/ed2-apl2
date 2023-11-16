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

    // Método para remover um programa pelo título
    public void remove(String titulo) {
        if (root != null) {
            root = root.remove(titulo); // Atualiza a raiz após a remoção
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

    // Outros métodos, como atualização, contagem de nós, etc., podem ser
    // adicionados aqui
}
