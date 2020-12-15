import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {

    public List<FlashCard> readFileLineByLine(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<FlashCard> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] result = line.split(",");
            lines.add(new FlashCard(result[0], result[3]));
        }
        return lines;
    }
}