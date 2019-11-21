import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CompetitionApp {
    public static void main(String[] args) {
        try {
            List<Player> players = readPlayers();
            FileUtils.writeListToFile(sortByScore(players));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Podaj imię, nazwisko u punkty oddzielone spacją.");
        } catch (NumberFormatException e) {
            System.err.println("Punkty muszą być wartością liczbową");
        }
    }

    private static List<Player> readPlayers() {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        String playerInfo;
        do {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            playerInfo = scanner.nextLine();

            if (!(playerInfo.toUpperCase().equals("STOP"))) {
                String[] playerInfoArr = playerInfo.split("\\s+");
                players.add(new Player(playerInfoArr[0], playerInfoArr[1], Integer.parseInt(playerInfoArr[2])));
            }
        } while (!(playerInfo.toUpperCase().equals("STOP")));
        scanner.close();
        return players;
    }

    private static List<Player> sortByScore(List<Player> players) {
        ScoreAndNameComparator comparator = new ScoreAndNameComparator();
        Collections.sort(players, comparator);
        return players;
    }
}
