public class NodeAVLProgramaNetflix extends ProgramaNetflix {
    // Ponteiros para os filhos esquerdo e direito do nó na árvore AVL
    NodeAVLProgramaNetflix left, right;

    // Altura do nó, usada para manter a árvore balanceada
    int height;

    // Construtor que cria um nó da árvore a partir dos dados do programa
    public NodeAVLProgramaNetflix(String id, String titulo, Tipo tipo, String descricao, int anoLancamento,
            String classificacaoIndicativa, int duracao, String genero, String paisOrigem, int temporadas,
            String imdbId, Float imdbScore, int imdbVotes, Float tmdbPopularity, Float tmdbScore) {
        super(id, titulo, tipo, descricao, anoLancamento, classificacaoIndicativa, duracao, genero, paisOrigem,
                temporadas, imdbId, imdbScore, imdbVotes, tmdbPopularity, tmdbScore);
        this.left = null;
        this.right = null;
        // Inicializa os dados do programa e define os filhos como nulos
    }

    // Construtor alternativo que cria um nó a partir de um objeto ProgramaNetflix
    public NodeAVLProgramaNetflix(ProgramaNetflix programa) {
        super(programa.getId(), programa.getTitulo(), programa.getTipo(), programa.getDescricao(),
                programa.getAnoLancamento(), programa.getClassificacaoIndicativa(), programa.getDuracao(),
                programa.getGenero(), programa.getPaisOrigem(), programa.getTemporadas(), programa.getImdbId(),
                programa.getImdbScore(), programa.getImdbVotes(), programa.getTmdbPopularity(),
                programa.getTmdbScore());
        this.left = null;
        this.right = null;
        // Inicializa o nó com as informações do programa fornecido
    }

    // Terceiro construtor que também aceita nós filhos esquerdo e direito
    public NodeAVLProgramaNetflix(ProgramaNetflix programa, NodeAVLProgramaNetflix left, NodeAVLProgramaNetflix right) {
        super(programa.getId(), programa.getTitulo(), programa.getTipo(), programa.getDescricao(),
                programa.getAnoLancamento(), programa.getClassificacaoIndicativa(), programa.getDuracao(),
                programa.getGenero(), programa.getPaisOrigem(), programa.getTemporadas(), programa.getImdbId(),
                programa.getImdbScore(), programa.getImdbVotes(), programa.getTmdbPopularity(),
                programa.getTmdbScore());
        this.left = left;
        this.right = right;
        // Inicializa o nó com as informações do programa e filhos esquerdo e direito
    }

    // Método privado para calcular a altura de um nó
    private int height(NodeAVLProgramaNetflix N) {
        if (N == null)
            return 0;
        return N.height;
        // Retorna 0 se o nó for nulo, caso contrário retorna a altura do nó
    }

    // Atualiza a altura do nó com base na altura de seus filhos
    private void updateHeight() {
        this.height = 1 + Math.max(height(left), height(right));
        // A altura é 1 mais a maior altura entre os filhos esquerdo e direito
    }

    // Calcula o fator de balanceamento do nó
    private int getBalanceFactor() {
        return height(left) - height(right);
        // Diferença entre as alturas dos filhos esquerdo e direito
    }

    // Realiza uma rotação à direita no nó para balancear a árvore
    private NodeAVLProgramaNetflix rightRotate() {
        NodeAVLProgramaNetflix x = this.left;
        NodeAVLProgramaNetflix T2 = x.right;

        x.right = this;
        this.left = T2;

        this.updateHeight();
        x.updateHeight();

        return x;
        // Rotação à direita é realizada e a altura dos nós afetados é atualizada
    }

    // Realiza uma rotação à esquerda no nó para balancear a árvore
    private NodeAVLProgramaNetflix leftRotate() {
        NodeAVLProgramaNetflix y = this.right;
        NodeAVLProgramaNetflix T2 = y.left;

        y.left = this;
        this.right = T2;

        this.updateHeight();
        y.updateHeight();

        return y;
        // Rotação à esquerda é realizada e a altura dos nós afetados é atualizada
    }

    // Insere um novo programa na árvore AVL e retorna a nova raiz após
    // balanceamento
    public NodeAVLProgramaNetflix insert(ProgramaNetflix programa) {
        if (programa.getTitulo().compareToIgnoreCase(this.getTitulo()) < 0) {
            if (this.left == null) {
                this.left = new NodeAVLProgramaNetflix(programa);
            } else {
                this.left = this.left.insert(programa);
            }
        } else {
            if (this.right == null) {
                this.right = new NodeAVLProgramaNetflix(programa);
            } else {
                this.right = this.right.insert(programa);
            }
        }

        this.updateHeight();

        int balance = getBalanceFactor();

        if (balance > 1 && programa.getTitulo().compareToIgnoreCase(this.left.getTitulo()) < 0)
            return rightRotate();

        if (balance < -1 && programa.getTitulo().compareToIgnoreCase(this.right.getTitulo()) > 0)
            return leftRotate();

        if (balance > 1 && programa.getTitulo().compareToIgnoreCase(this.left.getTitulo()) > 0) {
            this.left = this.left.leftRotate();
            return rightRotate();
        }

        if (balance < -1 && programa.getTitulo().compareToIgnoreCase(this.right.getTitulo()) < 0) {
            this.right = this.right.rightRotate();
            return leftRotate();
        }

        return this;
        // Insere o programa na posição correta e balanceia a árvore
    }

    // Procura um programa pelo título e retorna o nó correspondente
    public NodeAVLProgramaNetflix search(String titulo) {
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
        // Realiza uma busca binária na árvore AVL
    }

    // Remove um programa pelo título e retorna a nova raiz após balanceamento
    public NodeAVLProgramaNetflix remove(String titulo) {
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
                        NodeAVLProgramaNetflix min = this.right;
                        while (min.left != null) {
                            min = min.left;
                        }
                        this.setId(min.getId());
                        this.setTitulo(min.getTitulo());
                        this.setTipo(min.getTipo());
                        this.setDescricao(min.getDescricao());
                        this.setAnoLancamento(min.getAnoLancamento());
                        this.setClassificacaoIndicativa(min.getClassificacaoIndicativa());
                        this.setDuracao(min.getDuracao());
                        this.setGenero(min.getGenero());
                        this.setPaisOrigem(min.getPaisOrigem());
                        this.setTemporadas(min.getTemporadas());
                        this.setImdbId(min.getImdbId());
                        this.setImdbScore(min.getImdbScore());
                        this.setImdbVotes(min.getImdbVotes());
                        this.setTmdbPopularity(min.getTmdbPopularity());
                        this.setTmdbScore(min.getTmdbScore());
                        this.right = this.right.remove(min.getTitulo());
                        this.updateHeight();
                        int balance = getBalanceFactor();

                        if (balance > 1 && this.left.getBalanceFactor() >= 0)
                            return rightRotate();

                        if (balance < -1 && this.right.getBalanceFactor() <= 0)
                            return leftRotate();

                        if (balance > 1 && this.left.getBalanceFactor() < 0) {
                            this.left = this.left.leftRotate();
                            return rightRotate();
                        }

                        if (balance < -1 && this.right.getBalanceFactor() > 0) {
                            this.right = this.right.rightRotate();
                            return leftRotate();
                        }

                        return this;
                    }
                }
            }
        }
        if (titulo.compareToIgnoreCase(this.getTitulo()) < 0) {
            if (this.left == null)
                return this;
            else {
                this.left = this.left.remove(titulo);
                this.updateHeight();
                int balance = getBalanceFactor();

                if (balance > 1 && this.left.getBalanceFactor() >=

                        0)
                    return rightRotate();

                if (balance < -1 && this.right.getBalanceFactor() <= 0)
                    return leftRotate();

                if (balance > 1 && this.left.getBalanceFactor() < 0) {
                    this.left = this.left.leftRotate();
                    return rightRotate();
                }

                if (balance < -1 && this.right.getBalanceFactor() > 0) {
                    this.right = this.right.rightRotate();
                    return leftRotate();
                }

                return this;
            }
        } else {
            if (this.right == null)
                return this;
            else {
                this.right = this.right.remove(titulo);
                this.updateHeight();
                int balance = getBalanceFactor();

                if (balance > 1 && this.left.getBalanceFactor() >= 0)
                    return rightRotate();

                if (balance < -1 && this.right.getBalanceFactor() <= 0)
                    return leftRotate();

                if (balance > 1 && this.left.getBalanceFactor() < 0) {
                    this.left = this.left.leftRotate();
                    return rightRotate();
                }

                if (balance < -1 && this.right.getBalanceFactor() > 0) {
                    this.right = this.right.rightRotate();
                    return leftRotate();
                }

                return this;
            }
        }
        // Remove o programa, realiza ajustes necessários e balanceia a árvore
    }

    // Imprime a árvore em ordem (esquerda, raiz, direita)
    public void printInOrder() {
        if (this.left != null) {
            this.left.printInOrder();
        }
        System.out.println(this.toString());
        if (this.right != null) {
            this.right.printInOrder();
        }
        // Percorre a árvore e imprime os programas em ordem
    }

    // Imprime a árvore em pré-ordem (raiz, esquerda, direita)
    public void printPreOrder() {
        System.out.println(this.toString());
        if (this.left != null) {
            this.left.printPreOrder();
        }
        if (this.right != null) {
            this.right.printPreOrder();
        }
        // Percorre a árvore e imprime os programas em pré-ordem
    }

    // Imprime a árvore em pós-ordem (esquerda, direita, raiz)
    public void printPostOrder() {
        if (this.left != null) {
            this.left.printPostOrder();
        }
        if (this.right != null) {
            this.right.printPostOrder();
        }
        System.out.println(this.toString());
        // Percorre a árvore e imprime os programas em pós-ordem
    }

    // Retorna a representação em string do programa
    @Override
    public String toString() {
        return super.toString();
        // Retorna os detalhes do programa em formato de string
    }
}
