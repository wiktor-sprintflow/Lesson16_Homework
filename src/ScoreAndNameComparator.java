import java.util.Comparator;

public class ScoreAndNameComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        if (p1.getScore() > p2.getScore())
            return 1;
        else if (p1.getScore() < p2.getScore())
            return -1;
        else {
            if (p1.getLastName().compareTo(p2.getLastName()) > 0)
                return 1;
            else if (p1.getLastName().compareTo(p2.getLastName()) < 0)
                return -1;
            return p1.getFirstName().compareTo(p2.getFirstName());
        }
    }
}
