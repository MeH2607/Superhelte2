package comparator;
import domain.SuperHero;
import java.util.Comparator;
public class SuperHeroPowerComparator implements Comparator<SuperHero> {

    public int compare(SuperHero hero1, SuperHero hero2){
        return hero1.getSuperheroPower().compareToIgnoreCase(hero2.getSuperheroPower());
    }
}
