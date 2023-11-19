public class NodeBSTProgramaNetflix extends ProgramaNetflix {
    NodeBSTProgramaNetflix left, right;

    public NodeBSTProgramaNetflix(String id, String titulo, App.Tipo tipo, String descricao, int anoLancamento,
            String classificacaoIndicativa, int duracao, String genero, String paisOrigem, int temporadas,
            String imdbId, Float imdbScore, int imdbVotes, Float tmdbPopularity, Float tmdbScore) {
        super(id, titulo, tipo, descricao, anoLancamento, classificacaoIndicativa, duracao, genero, paisOrigem,
                temporadas, imdbId, imdbScore, imdbVotes, tmdbPopularity, tmdbScore);
        this.left = null;
        this.right = null;
    }

    public NodeBSTProgramaNetflix(ProgramaNetflix programa) {
        super(programa.getId(), programa.getTitulo(), programa.getTipo(), programa.getDescricao(),
                programa.getAnoLancamento(), programa.getClassificacaoIndicativa(), programa.getDuracao(),
                programa.getGenero(), programa.getPaisOrigem(), programa.getTemporadas(), programa.getImdbId(),
                programa.getImdbScore(), programa.getImdbVotes(), programa.getTmdbPopularity(),
                programa.getTmdbScore());
        this.left = null;
        this.right = null;
    }

    public NodeBSTProgramaNetflix(ProgramaNetflix programa, NodeBSTProgramaNetflix left, NodeBSTProgramaNetflix right) {
        super(programa.getId(), programa.getTitulo(), programa.getTipo(), programa.getDescricao(),
                programa.getAnoLancamento(), programa.getClassificacaoIndicativa(), programa.getDuracao(),
                programa.getGenero(), programa.getPaisOrigem(), programa.getTemporadas(), programa.getImdbId(),
                programa.getImdbScore(), programa.getImdbVotes(), programa.getTmdbPopularity(),
                programa.getTmdbScore());
        this.left = left;
        this.right = right;
    }

    public NodeBSTProgramaNetflix getLeft() {
        return left;
    }

    public void setLeft(NodeBSTProgramaNetflix left) {
        this.left = left;
    }

    public NodeBSTProgramaNetflix getRight() {
        return right;
    }

    public void setRight(NodeBSTProgramaNetflix right) {
        this.right = right;
    }

    public NodeBSTProgramaNetflix getPrograma() {
        return this;
    }

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
    }

    public NodeBSTProgramaNetflix remove(String id) {
        if (this.getId().equalsIgnoreCase(id)) {
            if (this.left == null && this.right == null) {
                return null;
            } else if (this.left == null) {
                return this.right;
            } else if (this.right == null) {
                return this.left;
            } else {
                NodeBSTProgramaNetflix aux = findMin(this.right);
                copyData(aux, this);
                this.right = this.right.remove(aux.getId());
                return this;
            }
        } else if (id.compareToIgnoreCase(this.getId()) < 0) {
            if (this.left != null) {
                this.left = this.left.remove(id);
            }
            return this;
        } else {
            if (this.right != null) {
                this.right = this.right.remove(id);
            }
            return this;
        }
    }

    private NodeBSTProgramaNetflix findMin(NodeBSTProgramaNetflix node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

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

    @Override
    public String toString() {
        return super.toString();
    }
}
