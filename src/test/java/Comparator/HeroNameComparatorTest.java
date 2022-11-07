package Comparator;

import Data.Database;
import Data.SuperHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeroNameComparatorTest {

    Database db = new Database();

    @BeforeEach
    void setUp() {
        //Opretter og tilføjer helte til databasen så det ikke skal gøres i hver test metode
        SuperHero testHero1 = new SuperHero("Peter Parker", "Spider-man",
                "Spider stuff", true, 1962);
        SuperHero testHero2 = new SuperHero("Clark Kent", "Superman",
                "Super strength, flight, lasers, shit what doesn't he have", false, 1938);
        SuperHero testHero3 = new SuperHero("Johnny",
                "Cool", true, 2000);
        SuperHero testHero4 = new SuperHero("Bruce Wayne", "Batman",
                "Money", true, 1939);
        //indsætter til databasen
        db.getHeroDatabase().addAll(Arrays.asList(testHero1, testHero2, testHero4));
    }

    @Test
    void compareWithoutNull() {
        SuperHero hero1 = db.getHeroDatabase().get(2);
        SuperHero hero2 = db.getHeroDatabase().get(0);
        int i = 0;
        if(hero1.getSuperheroName() == null){
            //return null == hero2.getSuperheroName() ? 0 : 1; //Denne metode fandt jeg online https://www.benchresources.net/java-8-how-to-sort-list-and-arrays-with-null-values/
            i = 1;
        }
        else if (hero2.getSuperheroName() == null) {
            i = -1;
        }
       else {
            i = hero1.getSuperheroName().compareToIgnoreCase(hero2.getSuperheroName());
        }
       assertTrue(i<0);
    }

    @Test
    void compareWithNull() {
        SuperHero hero1 = db.getHeroDatabase().get(2);
        SuperHero hero2 = new SuperHero("Johnny",
                "Cool", true, 2000);
        int i = 0;
        if(hero1.getSuperheroName() == null){
            //return null == hero2.getSuperheroName() ? 0 : 1; //Denne metode fandt jeg online https://www.benchresources.net/java-8-how-to-sort-list-and-arrays-with-null-values/
            i = 1;
        }
        else if (hero2.getSuperheroName() == null) {
            i = -1;
        }
       else {
            i = hero1.getSuperheroName().compareToIgnoreCase(hero2.getSuperheroName());
        }
       assertTrue(i<0);
    }

    void compareWithLowercase() {
        SuperHero hero1 = db.getHeroDatabase().get(2);
        SuperHero hero2 = new SuperHero("adam",
                "Cool", true, 2000);
        int i = 0;
        if(hero1.getSuperheroName() == null){
            //return null == hero2.getSuperheroName() ? 0 : 1; //Denne metode fandt jeg online https://www.benchresources.net/java-8-how-to-sort-list-and-arrays-with-null-values/
            i = 1;
        }
        else if (hero2.getSuperheroName() == null) {
            i = -1;
        }
        else {
            i = hero1.getSuperheroName().compareToIgnoreCase(hero2.getSuperheroName());
        }
        assertTrue(i<0);
    }

}