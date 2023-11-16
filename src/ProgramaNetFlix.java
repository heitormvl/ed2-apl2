public class ProgramaNetflix {

    // Enumeração para os tipos de programas: filme ou série
    enum Tipo {
        filme,
        serie
    }

    // Atributos privados da classe para armazenar as informações de um programa
    // Netflix
    private String id;
    private String titulo;
    private Tipo tipo;
    private String descricao;
    private int anoLancamento;
    private String classificacaoIndicativa;
    private int duracao;
    private String genero;
    private String paisOrigem;
    private int temporadas;
    private String imdbId;
    private Float imdbScore;
    private int imdbVotes;
    private Float tmdbPopularity;
    private Float tmdbScore;

    // Construtor padrão
    public ProgramaNetflix() {
        // Este construtor é vazio e permite a criação de um objeto sem inicializar os
        // campos
    }

    // Construtor com parâmetros para inicializar todos os atributos da classe
    public ProgramaNetflix(String id, String titulo, Tipo tipo, String descricao, int anoLancamento,
            String classificacaoIndicativa, int duracao, String genero, String paisOrigem, int temporadas,
            String imdbId, Float imdbScore, int imdbVotes, Float tmdbPopularity, Float tmdbScore) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.duracao = duracao;
        this.genero = genero;
        this.paisOrigem = paisOrigem;
        this.temporadas = temporadas;
        this.imdbId = imdbId;
        this.imdbScore = imdbScore;
        this.imdbVotes = imdbVotes;
        this.tmdbPopularity = tmdbPopularity;
        this.tmdbScore = tmdbScore;
    }

    // Inicializa os atributos com os valores fornecidos

    // Métodos getters para acessar os valores dos atributos
    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public String getImdbId() {
        return imdbId;
    }

    public Float getImdbScore() {
        return imdbScore;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public Float getTmdbPopularity() {
        return tmdbPopularity;
    }

    public Float getTmdbScore() {
        return tmdbScore;
    }

    // Métodos setters para modificar os valores dos atributos
    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setImdbScore(Float imdbScore) {
        this.imdbScore = imdbScore;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public void setTmdbPopularity(Float tmdbPopularity) {
        this.tmdbPopularity = tmdbPopularity;
    }

    public void setTmdbScore(Float tmdbScore) {
        this.tmdbScore = tmdbScore;
    }

    // Método toString para representar o objeto como uma string
    @Override
    public String toString() {
        return "ProgramaNetflix [anoLancamento=" + anoLancamento + ", classificacaoIndicativa="
                + classificacaoIndicativa + ", descricao=" + descricao + ", duracao=" + duracao + ", genero=" + genero
                + ", id=" + id + ", imdbId=" + imdbId + ", imdbScore=" + imdbScore + ", imdbVotes=" + imdbVotes
                + ", paisOrigem=" + paisOrigem + ", temporadas=" + temporadas + ", tipo=" + tipo + ", titulo=" + titulo
                + ", tmdbPopularity=" + tmdbPopularity + ", tmdbScore=" + tmdbScore + "]";
        // Retorna uma string que representa todos os atributos do programa Netflix
    }
}
