
package Comparator;
import java.util.Comparator;
import Data.SuperHero;

public class NameComparator implements Comparator<SuperHero> {
    public int compare(SuperHero c1, SuperHero c2){
        return c1.getName().compareTo(c2.getName());
    }

}