public class Node {
    private ProgramaNetFlix valor;
    private Node esquerda;
    private Node direita;

    // Construtor
    public Node(ProgramaNetFlix valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    // Getters e Setters
    public ProgramaNetFlix getValor() {
        return valor;
    }

    public void setValor(ProgramaNetFlix valor) {
        this.valor = valor;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

}
