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

    // Método para buscar um programa pelo título
    public NodeBSTProgramaNetflix search(String titulo) {
        if (this.getTitulo().equalsIgnoreCase(titulo)) {
            return this;
        } else {
            if (titulo.compareToIgnoreCase(this.getTitulo()) < 0) {
                if (this.left == null) {
                    return null;
                } else {
                    return this.left.search(titulo);
                }
            } else {
                if (this.right == null) {
                    return null;
                } else {
                    return this.right.search(titulo);
                }
            }
        }
        // Realiza uma busca binária pelo título na árvore
    }

    // Método para remover um programa pelo título
    public NodeBSTProgramaNetflix remove(String titulo) {
        if (this.getTitulo().equalsIgnoreCase(titulo)) {
            if (this.left == null && this.right == null) {
                return null;
            } else {
                if (this.left == null) {
                    return this.right;
                } else {
                    if (this.right == null) {
                        return this.left;
                    } else {
                        NodeBSTProgramaNetflix aux = this.right;
                        while (aux.left != null) {
                            aux = aux.left;
                        }
                        this.setTitulo(aux.getTitulo());
                        this.setTipo(aux.getTipo());
                        this.setDescricao(aux.getDescricao());
                        this.setAnoLancamento(aux.getAnoLancamento());
                        this.setClassificacaoIndicativa(aux.getClassificacaoIndicativa());
                        this.setDuracao(aux.getDuracao());
                        this.setGenero(aux.getGenero());
                        this.setPaisOrigem(aux.getPaisOrigem());
                        this.setTemporadas(aux.getTemporadas());
                        this.setImdbId(aux.getImdbId());
                        this.setImdbScore(aux.getImdbScore());
                        this.setImdbVotes(aux.getImdbVotes());
                        this.setTmdbPopularity(aux.getTmdbPopularity());
                        this.setTmdbScore(aux.getTmdbScore());
                        this.right = this.right.remove(aux.getTitulo());
                        return this;
                    }
                }
            }
        } else {
            if (titulo.compareToIgnoreCase(this.getTitulo()) < 0) {
                if (this.left == null)
                    return this;
                else {
                    this.left = this.left.remove(titulo);
                    return this;
                }
            } else {
                if (this.right == null)
                    return this;
                else {
                    this.right = this.right.remove(titulo);
                    return this;
                }
            }
        }
        // Remove o programa e reorganiza a árvore para manter a estrutura de busca
        // binária
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
