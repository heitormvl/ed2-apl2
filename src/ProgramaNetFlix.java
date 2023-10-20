import java.util.List;

public class ProgramaNetFlix {

    // Enum para ShowType
    public enum ShowType {
        SHOW, MOVIE
    }

    // Atributos

    private int id;
    private String titulo;
    private ShowType show_type;
    private String descricao;
    private int release_year;
    private String age_certification;
    private int runtime;
    private List<String> generos;
    private List<String> production_countries;
    private int temporadas;
    private String imdb_id;
    private int imdb_score;
    private int imdb_votes;
    private int tmdb_popularity;
    private int tmdb_score;

    // Construtor

    public ProgramaNetFlix(int id, String titulo, ShowType show_type, String descricao, int release_year,
            String age_certification, int runtime, List<String> generos, List<String> production_countries,
            int temporadas,
            String imdb_id, int imdb_score, int imdb_votes, int tmdb_popularity, int tmdb_score) {
        this.id = id;
        this.titulo = titulo;
        this.show_type = show_type;
        this.descricao = descricao;
        this.release_year = release_year;
        this.age_certification = age_certification;
        this.runtime = runtime;
        this.generos = generos;
        this.production_countries = production_countries;
        this.temporadas = temporadas;
        this.imdb_id = imdb_id;
        this.imdb_score = imdb_score;
        this.imdb_votes = imdb_votes;
        this.tmdb_popularity = tmdb_popularity;
        this.tmdb_score = tmdb_score;
    }

    // Getters e Setters

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public ShowType getShow_type() {
        return this.show_type;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getRelease_year() {
        return this.release_year;
    }

    public String getAge_certification() {
        return this.age_certification;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public List<String> getGeneros() {
        return this.generos;
    }

    public List<String> getProduction_countries() {
        return this.production_countries;
    }

    public int getTemporadas() {
        return this.temporadas;
    }

    public String getImdb_id() {
        return this.imdb_id;
    }

    public int getImdb_score() {
        return this.imdb_score;
    }

    public int getImdb_votes() {
        return this.imdb_votes;
    }

    public int getTmdb_popularity() {
        return this.tmdb_popularity;
    }

    public int getTmdb_score() {
        return this.tmdb_score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setShow_type(ShowType show_type) {
        this.show_type = show_type;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setAge_certification(String age_certification) {
        this.age_certification = age_certification;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public void setProduction_countries(List<String> production_countries) {
        this.production_countries = production_countries;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public void setImdb_score(int imdb_score) {
        this.imdb_score = imdb_score;
    }

    public void setImdb_votes(int imdb_votes) {
        this.imdb_votes = imdb_votes;
    }

    public void setTmdb_popularity(int tmdb_popularity) {
        this.tmdb_popularity = tmdb_popularity;
    }

    public void setTmdb_score(int tmdb_score) {
        this.tmdb_score = tmdb_score;
    }

    // toString

    @Override
    public String toString() {
        return "ProgramaNetFlix {" +
                " id='" + id + "'," +
                " titulo='" + titulo + "'," +
                " show_type='" + show_type + "'," +
                " descricao='" + descricao + "'," +
                " release_year='" + release_year + "'," +
                " age_certification='" + age_certification + "'," +
                " runtime='" + runtime + "'," +
                " generos=" + generos + "," +
                " production_countries=" + production_countries + "," +
                " temporadas='" + temporadas + "'," +
                " imdb_id='" + imdb_id + "'," +
                " imdb_score='" + imdb_score + "'," +
                " imdb_votes='" + imdb_votes + "'," +
                " tmdb_popularity='" + tmdb_popularity + "'," +
                " tmdb_score='" + tmdb_score + "'" +
                "}";
    }
}

// Referências:
// https://www.w3schools.com/java/java_enums.asp (Enum)