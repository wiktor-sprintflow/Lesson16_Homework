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
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Podaj imię, nazwisko u punkty oddzielone pojedyńczą spacją. Punkty muszą być wartością liczbową");
        }
    }

    private static List<Player> readPlayers() {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        String playerInfo;
        do {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            playerInfo = scanner.nextLine();

            if (!(playerInfo.equals("stop") || playerInfo.equals("STOP"))) {
                String[] playerInfoArr = playerInfo.split(" ");
                players.add(new Player(playerInfoArr[0], playerInfoArr[1], Integer.parseInt(playerInfoArr[2])));
            }
        } while (!(playerInfo.equals("stop") || playerInfo.equals("STOP")));
        return players;
    }

    private static List<Player> sortByScore(List<Player> players) {
        ScoreComparator scoreComparator = new ScoreComparator();
        Collections.sort(players, scoreComparator);
        return players;
    }
}
