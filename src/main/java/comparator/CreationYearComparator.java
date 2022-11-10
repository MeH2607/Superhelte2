package comparator;
import domain.SuperHero;
import java.util.Comparator;
public class CreationYearComparator implements Comparator<SuperHero> {
    public int compare(SuperHero hero1, SuperHero hero2) {
        if (hero1.getCreationYear() > hero2.getCreationYear()) {
            return 1;
        } else if (hero2.getCreationYear() > hero1.getCreationYear()) {
            return -1;
        } else {
            return 0;
        }
    }
}
