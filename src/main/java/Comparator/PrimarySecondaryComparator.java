package Comparator;
import Data.SuperHero;
import java.util.Comparator;
public class PrimarySecondaryComparator implements Comparator<SuperHero> {

    public int compare(SuperHero hero1, SuperHero hero2){
        if (hero1.getSuperheroName().compareToIgnoreCase(hero2.getSuperheroName()) == 0)
            return hero1.getName().compareTo(hero2.getName());
        else
            return hero1.getSuperheroName().compareToIgnoreCase(hero2.getSuperheroName());

    }
}