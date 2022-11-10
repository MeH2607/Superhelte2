package comparator;
import java.util.Comparator;
import domain.SuperHero;
public class NameComparator implements Comparator<SuperHero> {
    public int compare(SuperHero hero1, SuperHero hero2){
        return hero1.getName().compareToIgnoreCase(hero2.getName());
    }

}