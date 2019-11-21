import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class FileUtils {
    private static final String PLAYERS_FILE = "stats.csv";

    static void writeListToFile(List<Player> list) throws IOException {
        File file = new File(PLAYERS_FILE);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < list.size(); i++) {
            String player = list.get(i).toCsv();
            bufferedWriter.write(String.valueOf(player));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}