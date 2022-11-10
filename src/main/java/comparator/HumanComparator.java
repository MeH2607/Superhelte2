package comparator;
import domain.SuperHero;
import java.util.Comparator;

public class HumanComparator implements Comparator<SuperHero> {
    public int compare(SuperHero hero1, SuperHero hero2) {
        return Boolean.compare(hero1.getIsHuman(), hero2.getIsHuman());
    }
}
