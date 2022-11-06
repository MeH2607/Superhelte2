
package Comparator;
import java.util.Comparator;
import Data.SuperHero;

public class HeroNameComparator implements Comparator<SuperHero> {

    public int compare(SuperHero hero1, SuperHero hero2){
        return hero1.getSuperheroName().compareTo(hero2.getSuperheroName());
    }
}
