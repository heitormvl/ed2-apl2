public class NodeAVLProgramaNetflix extends ProgramaNetflix {
    NodeAVLProgramaNetflix left, right;
    int height;

    public NodeAVLProgramaNetflix(String id, String titulo, App.Tipo tipo, String descricao, int anoLancamento,
            String classificacaoIndicativa, int duracao, String genero, String paisOrigem, int temporadas,
            String imdbId, Float imdbScore, int imdbVotes, Float tmdbPopularity, Float tmdbScore) {
        super(id, titulo, tipo, descricao, anoLancamento, classificacaoIndicativa, duracao, genero, paisOrigem,
                temporadas, imdbId, imdbScore, imdbVotes, tmdbPopularity, tmdbScore);
        this.left = null;
        this.right = null;
    }

    public NodeAVLProgramaNetflix(ProgramaNetflix programa) {
        super(programa.getId(), programa.getTitulo(), programa.getTipo(), programa.getDescricao(),
                programa.getAnoLancamento(), programa.getClassificacaoIndicativa(), programa.getDuracao(),
                programa.getGenero(), programa.getPaisOrigem(), programa.getTemporadas(), programa.getImdbId(),
                programa.getImdbScore(), programa.getImdbVotes(), programa.getTmdbPopularity(),
                programa.getTmdbScore());
        this.left = null;
        this.right = null;
    }

    public NodeAVLProgramaNetflix(ProgramaNetflix programa, NodeAVLProgramaNetflix left, NodeAVLProgramaNetflix right) {
        super(programa.getId(), programa.getTitulo(), programa.getTipo(), programa.getDescricao(),
                programa.getAnoLancamento(), programa.getClassificacaoIndicativa(), programa.getDuracao(),
                programa.getGenero(), programa.getPaisOrigem(), programa.getTemporadas(), programa.getImdbId(),
                programa.getImdbScore(), programa.getImdbVotes(), programa.getTmdbPopularity(),
                programa.getTmdbScore());
        this.left = left;
        this.right = right;
    }

    public int height(NodeAVLProgramaNetflix N) {
        if (N == null)
            return 0;
        return N.height;
    }

    public void updateHeight() {
        this.height = 1 + Math.max(height(left), height(right));
    }

    public int getBalanceFactor() {
        return height(left) - height(right);
    }

    public NodeAVLProgramaNetflix rightRotate() {
        NodeAVLProgramaNetflix x = this.left;
        NodeAVLProgramaNetflix T2 = x.right;

        x.right = this;
        this.left = T2;

        this.updateHeight();
        x.updateHeight();

        return x;
    }

    public NodeAVLProgramaNetflix leftRotate() {
        NodeAVLProgramaNetflix y = this.right;
        NodeAVLProgramaNetflix T2 = y.left;

        y.left = this;
        this.right = T2;

        this.updateHeight();
        y.updateHeight();

        return y;
    }

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
    }

    public NodeAVLProgramaNetflix search(String titulo) {
        if (this.getTitulo().equalsIgnoreCase(titulo)) {
            return this;
        } else {
            if (titulo.compareToIgnoreCase(this.getTitulo()) < 0) {
                return this.left != null ? this.left.search(titulo) : null;
            } else {
                return this.right != null ? this.right.search(titulo) : null;
            }
        }
    }

    public NodeAVLProgramaNetflix remove(String titulo) {
        if (this.getTitulo().equalsIgnoreCase(titulo)) {
            if (this.left == null && this.right == null) {
                return null;
            } else if (this.left == null) {
                return this.right;
            } else if (this.right == null) {
                return this.left;
            } else {
                NodeAVLProgramaNetflix min = minValueNode(this.right);
                this.copyData(min);
                this.right = this.right.remove(min.getTitulo());
            }
        } else if (titulo.compareToIgnoreCase(this.getTitulo()) < 0) {
            if (this.left != null) {
                this.left = this.left.remove(titulo);
            }
        } else {
            if (this.right != null) {
                this.right = this.right.remove(titulo);
            }
        }

        if (this.left == null && this.right == null) {
            return null;
        }

        this.updateHeight();
        return balanceNode(this);
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

    public void copyData(NodeAVLProgramaNetflix temp) {
        // Copying data from temp to this node
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private NodeAVLProgramaNetflix minValueNode(NodeAVLProgramaNetflix node) {
        NodeAVLProgramaNetflix current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private NodeAVLProgramaNetflix balanceNode(NodeAVLProgramaNetflix node) {
        int balance = node.getBalanceFactor();

        if (balance > 1 && node.left.getBalanceFactor() >= 0)
            return node.rightRotate();

        if (balance < -1 && node.right.getBalanceFactor() <= 0)
            return node.leftRotate();

        if (balance > 1 && node.left.getBalanceFactor() < 0) {
            node.left = node.left.leftRotate();
            return node.rightRotate();
        }

        if (balance < -1 && node.right.getBalanceFactor() > 0) {
            node.right = node.right.rightRotate();
            return node.leftRotate();
        }

        return node;
    }
}
