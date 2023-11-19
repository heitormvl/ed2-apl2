public class ProgramaNetflix {

    enum Tipo {
        filme,
        serie
    }

    private String id;
    private String titulo;
    private App.Tipo tipo;
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

    public ProgramaNetflix() {
        // Empty constructor
    }

    public ProgramaNetflix(String id, String titulo, App.Tipo tipo, String descricao, int anoLancamento,
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public App.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(App.Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public Float getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(Float imdbScore) {
        this.imdbScore = imdbScore;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public Float getTmdbPopularity() {
        return tmdbPopularity;
    }

    public void setTmdbPopularity(Float tmdbPopularity) {
        this.tmdbPopularity = tmdbPopularity;
    }

    public Float getTmdbScore() {
        return tmdbScore;
    }

    public void setTmdbScore(Float tmdbScore) {
        this.tmdbScore = tmdbScore;
    }

    @Override
    public String toString() {
        return "ProgramaNetflix [anoLancamento=" + anoLancamento + ", classificacaoIndicativa="
                + classificacaoIndicativa
                + ", descricao=" + descricao + ", duracao=" + duracao + ", genero=" + genero + ", id=" + id
                + ", imdbId=" + imdbId + ", imdbScore=" + imdbScore + ", imdbVotes=" + imdbVotes
                + ", paisOrigem=" + paisOrigem + ", temporadas=" + temporadas + ", tipo=" + tipo + ", titulo=" + titulo
                + ", tmdbPopularity=" + tmdbPopularity + ", tmdbScore=" + tmdbScore + "]";
    }
}
