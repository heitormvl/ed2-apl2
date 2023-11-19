import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class App {

    // Enumeração Tipo (ajuste conforme necessário)
    public enum Tipo {
        SHOW, MOVIE // Exemplo de valores para a enumeração
    }

    // Classe ImportAndInsert como classe interna da App
    public static class ImportAndInsert {

        public static void importAndInsert(String filePath, BST bst) {
            try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
                String[] fields;

                // Pular a linha de cabeçalho
                csvReader.readNext();

                while ((fields = csvReader.readNext()) != null) {
                    if (fields.length < 15) {
                        continue; // Verificar se há campos suficientes
                    }

                    // Converter e ajustar campos conforme necessário
                    String id = fields[0];
                    String titulo = fields[1];
                    App.Tipo tipo = determinarTipo(fields[2]);
                    String descricao = fields[3];
                    int anoLancamento = Integer.parseInt(fields[4]);
                    String classificacaoIndicativa = fields[5];
                    int duracao = Integer.parseInt(fields[6]);
                    String genero = fields[7];
                    String paisOrigem = fields[8];
                    int temporadas = tipo == App.Tipo.MOVIE ? 0 : parseSeasons(fields[9]);
                    String imdbId = fields[10];
                    float imdbScore = fields[11].isEmpty() ? 0 : Float.parseFloat(fields[11]);
                    int imdbVotes = fields[12].isEmpty() ? 0 : (int) Float.parseFloat(fields[12]);
                    float tmdbPopularity = fields[13].isEmpty() ? 0 : Float.parseFloat(fields[13]);
                    float tmdbScore = fields[14].isEmpty() ? 0 : Float.parseFloat(fields[14]);

                    // Criar um novo ProgramaNetflix
                    ProgramaNetflix programa = new ProgramaNetflix(id, titulo, tipo, descricao, anoLancamento,
                            classificacaoIndicativa, duracao, genero, paisOrigem, temporadas, imdbId, imdbScore,
                            imdbVotes, tmdbPopularity, tmdbScore);

                    // Inserir o programa na BST
                    bst.insert(programa);
                }

            } catch (IOException | CsvValidationException e) {
                e.printStackTrace();
            }
        }

        private static int parseSeasons(String seasonsField) {
            if (seasonsField.isEmpty()) {
                return 0; // ou algum valor padrão para temporadas
            } else {
                return (int) Float.parseFloat(seasonsField);
            }
        }

        private static App.Tipo determinarTipo(String tipoString) {
            if (tipoString.equalsIgnoreCase("SHOW")) {
                return App.Tipo.SHOW;
            } else if (tipoString.equalsIgnoreCase("MOVIE")) {
                return App.Tipo.MOVIE;
            } else {
                throw new IllegalArgumentException("Tipo desconhecido: " + tipoString);
            }
        }
    }

    // Main

    public static void main(String[] args) {
        BST bst = new BST();

        // Importar e inserir os programas
        ImportAndInsert.importAndInsert("C:\\Users\\heito\\Downloads\\archive\\titles.csv", bst);

        // Gerar o arquivo CSV da BST
        bst.exportCsv("C:\\Users\\heito\\Downloads\\exported_titles.csv");
    }
}
