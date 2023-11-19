import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ImportAndInsert {

    public static void importAndInsert(String filePath, TreeInterface tree) {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] fields;
            csvReader.readNext();

            while ((fields = csvReader.readNext()) != null) {
                if (fields.length < 15) {
                    continue;
                }

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

                ProgramaNetflix programa = new ProgramaNetflix(id, titulo, tipo, descricao, anoLancamento,
                        classificacaoIndicativa, duracao, genero, paisOrigem, temporadas, imdbId, imdbScore,
                        imdbVotes, tmdbPopularity, tmdbScore);

                tree.insert(programa);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    private static int parseSeasons(String seasonsField) {
        if (seasonsField.isEmpty()) {
            return 0;
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
