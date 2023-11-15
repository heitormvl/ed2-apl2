public class ProgramaNetflix {

    // Enumerador para o tipo de programa
    enum Tipo {
        filme,
        serie
    }

    // Atributos da classe
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

    // Inclua todos os outros atributos necessários

    // Construtor sem argumentos
    public ProgramaNetflix() {
        // Inicialize os atributos com valores padrão
    }

    // Construtor com argumentos
    public ProgramaNetflix(String titulo, Tipo tipo, String descricao, int anoLancamento,
            String classificacaoIndicativa, int duracao, String genero, String paisOrigem, int temporadas,
            String imdbId, Float imdbScore, int imdbVotes, Float tmdbPopularity, Float tmdbScore) {
        // Inicialize os atributos com os valores passados como argumento
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

    // Getters
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

    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        // Valide o título antes de atribuir
        this.titulo = titulo;
    }

    public void setTipo(Tipo tipo) {
        // Valide o tipo antes de atribuir
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        // Valide a descrição antes de atribuir
        this.descricao = descricao;
    }

    public void setAnoLancamento(int anoLancamento) {
        // Valide o ano de lançamento antes de atribuir
        this.anoLancamento = anoLancamento;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        // Valide a classificação indicativa antes de atribuir
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public void setDuracao(int duracao) {
        // Valide a duração antes de atribuir
        this.duracao = duracao;
    }

    public void setGenero(String genero) {
        // Valide o gênero antes de atribuir
        this.genero = genero;
    }

    public void setPaisOrigem(String paisOrigem) {
        // Valide o país de origem antes de atribuir
        this.paisOrigem = paisOrigem;
    }

    public void setTemporadas(int temporadas) {
        // Valide o número de temporadas antes de atribuir
        this.temporadas = temporadas;
    }

    public void setImdbId(String imdbId) {
        // Valide o ID do IMDb antes de atribuir
        this.imdbId = imdbId;
    }

    public void setImdbScore(Float imdbScore) {
        // Valide a pontuação do IMDb antes de atribuir
        this.imdbScore = imdbScore;
    }

    public void setImdbVotes(int imdbVotes) {
        // Valide o número de votos do IMDb antes de atribuir
        this.imdbVotes = imdbVotes;
    }

    public void setTmdbPopularity(Float tmdbPopularity) {
        // Valide a popularidade do TMDb antes de atribuir
        this.tmdbPopularity = tmdbPopularity;
    }

    public void setTmdbScore(Float tmdbScore) {
        // Valide a pontuação do TMDb antes de atribuir
        this.tmdbScore = tmdbScore;
    }

    // Método toString
    @Override
    public String toString() {
        return "ProgramaNetflix [anoLancamento=" + anoLancamento + ", classificacaoIndicativa="
                + classificacaoIndicativa + ", descricao=" + descricao + ", duracao=" + duracao + ", genero=" + genero
                + ", id=" + id + ", imdbId=" + imdbId + ", imdbScore=" + imdbScore + ", imdbVotes=" + imdbVotes
                + ", paisOrigem=" + paisOrigem + ", temporadas=" + temporadas + ", tipo=" + tipo + ", titulo=" + titulo
                + ", tmdbPopularity=" + tmdbPopularity + ", tmdbScore=" + tmdbScore + "]";
    }

    // Métodos de validação (opcional)
    // Exemplo: validar o ano de lançamento
}
