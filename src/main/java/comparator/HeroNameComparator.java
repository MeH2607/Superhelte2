package comparator;
import java.util.Comparator;
import domain.SuperHero;

public class HeroNameComparator implements Comparator<SuperHero> {

    public int compare(SuperHero hero1, SuperHero hero2){
        if(hero1.getSuperheroName() == null){
            //return null == hero2.getSuperheroName() ? 0 : 1; //Denne metode fandt jeg online https://www.benchresources.net/java-8-how-to-sort-list-and-arrays-with-null-values/
            return 1;
        }
        else if (hero2.getSuperheroName() == null) {
            return -1;
        }
        return hero1.getSuperheroName().compareToIgnoreCase(hero2.getSuperheroName()); //Hvorfor virker denne her omvendt :sob:
    }
}
