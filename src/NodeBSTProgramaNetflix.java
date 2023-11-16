public class NodeBSTProgramaNetflix extends ProgramaNetflix {
    // Ponteiros para os filhos esquerdo e direito na árvore de busca binária
    NodeBSTProgramaNetflix left, right;

    // Construtor que inicializa um nó da árvore com as informações do programa
    public NodeBSTProgramaNetflix(String id, String titulo, Tipo tipo, String descricao, int anoLancamento,
            String classificacaoIndicativa, int duracao, String genero, String paisOrigem, int temporadas,
            String imdbId, Float imdbScore, int imdbVotes, Float tmdbPopularity, Float tmdbScore) {
        super(id, titulo, tipo, descricao, anoLancamento, classificacaoIndicativa, duracao, genero, paisOrigem,
                temporadas, imdbId, imdbScore, imdbVotes, tmdbPopularity, tmdbScore);
        this.left = null;
        this.right = null;
        // Chama o construtor da superclasse e inicializa os filhos como nulos
    }

    // Construtor que aceita um objeto ProgramaNetflix e inicializa o nó
    public NodeBSTProgramaNetflix(ProgramaNetflix programa) {
        super(programa.getId(), programa.getTitulo(), programa.getTipo(), programa.getDescricao(),
                programa.getAnoLancamento(), programa.getClassificacaoIndicativa(), programa.getDuracao(),
                programa.getGenero(), programa.getPaisOrigem(), programa.getTemporadas(), programa.getImdbId(),
                programa.getImdbScore(), programa.getImdbVotes(), programa.getTmdbPopularity(),
                programa.getTmdbScore());
        this.left = null;
        this.right = null;
        // Inicializa o nó com as informações do programa
    }

    // Construtor que também aceita nós filhos esquerdo e direito
    public NodeBSTProgramaNetflix(ProgramaNetflix programa, NodeBSTProgramaNetflix left, NodeBSTProgramaNetflix right) {
        super(programa.getId(), programa.getTitulo(), programa.getTipo(), programa.getDescricao(),
                programa.getAnoLancamento(), programa.getClassificacaoIndicativa(), programa.getDuracao(),
                programa.getGenero(), programa.getPaisOrigem(), programa.getTemporadas(), programa.getImdbId(),
                programa.getImdbScore(), programa.getImdbVotes(), programa.getTmdbPopularity(),
                programa.getTmdbScore());
        this.left = left;
        this.right = right;
        // Inicializa o nó com as informações do programa e com filhos específicos
    }

    // Métodos getters e setters para os nós filhos
    public NodeBSTProgramaNetflix getLeft() {
        return left;
    }

    public NodeBSTProgramaNetflix getRight() {
        return right;
    }

    public void setLeft(NodeBSTProgramaNetflix left) {
        this.left = left;
    }

    public void setRight(NodeBSTProgramaNetflix right) {
        this.right = right;
    }

    // Método para inserir um novo programa na árvore
    public void insert(ProgramaNetflix programa) {
        if (programa.getTitulo().compareToIgnoreCase(this.getTitulo()) < 0) {
            if (this.left == null) {
                this.left = new NodeBSTProgramaNetflix(programa);
            } else {
                this.left.insert(programa);
            }
        } else {
            if (this.right == null) {
                this.right = new NodeBSTProgramaNetflix(programa);
            } else {
                this.right.insert(programa);
            }
        }
        // Insere o programa de acordo com a ordem alfabética dos títulos
    }

    // Método para remover um programa pelo ID
    public NodeBSTProgramaNetflix remove(String id) {
        if (this.getId().equalsIgnoreCase(id)) {
            if (this.left == null && this.right == null) {
                return null; // Nó sem filhos
            } else if (this.left == null) {
                return this.right; // Nó com apenas um filho à direita
            } else if (this.right == null) {
                return this.left; // Nó com apenas um filho à esquerda
            } else {
                // Nó com dois filhos
                NodeBSTProgramaNetflix aux = findMin(this.right);
                // Copiando os dados do sucessor para este nó
                copyData(aux, this);
                // Removendo o sucessor
                this.right = this.right.remove(aux.getId());
                return this;
            }
        } else if (id.compareToIgnoreCase(this.getId()) < 0) {
            if (this.left != null) {
                this.left = this.left.remove(id);
            }
            return this; // Retorna o nó atual após a remoção da subárvore esquerda
        } else {
            if (this.right != null) {
                this.right = this.right.remove(id);
            }
            return this; // Retorna o nó atual após a remoção da subárvore direita
        }
    }

    // Método para encontrar o nó mínimo (usado na remoção)
    private NodeBSTProgramaNetflix findMin(NodeBSTProgramaNetflix node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Método para copiar dados de um nó para outro
    private void copyData(NodeBSTProgramaNetflix source, NodeBSTProgramaNetflix destination) {
        destination.setId(source.getId());
        destination.setTitulo(source.getTitulo());
        destination.setTipo(source.getTipo());
        destination.setDescricao(source.getDescricao());
        destination.setAnoLancamento(source.getAnoLancamento());
        destination.setClassificacaoIndicativa(source.getClassificacaoIndicativa());
        destination.setDuracao(source.getDuracao());
        destination.setGenero(source.getGenero());
        destination.setPaisOrigem(source.getPaisOrigem());
        destination.setTemporadas(source.getTemporadas());
        destination.setImdbId(source.getImdbId());
        destination.setImdbScore(source.getImdbScore());
        destination.setImdbVotes(source.getImdbVotes());
        destination.setTmdbPopularity(source.getTmdbPopularity());
        destination.setTmdbScore(source.getTmdbScore());
    }

    // Métodos para imprimir a árvore em diferentes ordens: in-order, pre-order e
    // post-order
    public void printInOrder() {
        if (this.left != null) {
            this.left.printInOrder();
        }
        System.out.println(this.toString());
        if (this.right != null) {
            this.right.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.println(this.toString());
        if (this.left != null) {
            this.left.printPreOrder();
        }
        if (this.right != null) {
            this.right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (this.left != null) {
            this.left.printPostOrder();
        }
        if (this.right != null) {
            this.right.printPostOrder();
        }
        System.out.println(this.toString());
    }

    // Representação em string do programa
    @Override
    public String toString() {
        return super.toString();
        // Retorna os detalhes do programa em formato de string
    }
}
