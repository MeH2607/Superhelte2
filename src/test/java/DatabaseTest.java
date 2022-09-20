import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database db = new Database();


    @Test
    void addToDatabase() {
        SuperHero testHero = new SuperHero("Peter Parker", "Spider-man",
                "Spider stuff", true, 1960);
        db.getHeroDatabase().add(testHero);
        int expectedListSize = 1;
        String expectedName = "Peter Parker";

      /*  assertEquals(expectedListSize, db.getHeroDatabase().size());
        assertEquals(expectedName, testHero.getName());*/

        assertAll("Tester nyindsatte helt",
                () -> assertEquals(expectedListSize, db.getHeroDatabase().size()),
                () -> assertEquals(expectedName, testHero.getName()),
                () -> assertTrue(testHero.isHuman())
        );
    }


    @Test
    void testAddManyToDatabase() {
        SuperHero testHero1 = new SuperHero("Peter Parker", "Spider-man",
                "Spider stuff", true, 1962);
        SuperHero testHero2 = new SuperHero("Clark Kent", "Superman",
                "Super strength, flight, lasers, shit what doesn't he have", false, 1938);
        SuperHero testHero3 = new SuperHero("Johnny",
                "Cool as shit", true, 2000);
        SuperHero testHero4 = new SuperHero("Bruce Wayne", "Batman",
                "Money", true, 1939);
        db.getHeroDatabase().addAll(Arrays.asList(testHero1, testHero2, testHero3, testHero4));
        int expectedListSize = 4;

        assertEquals(expectedListSize, db.getHeroDatabase().size());

    }

    @Test
    void searchForHeroList() {
        //Indsætter helte man kan søge efter
        SuperHero testHero1 = new SuperHero("Peter Parker", "Spider-man",
                "Spider stuff", true, 1962);
        SuperHero testHero2 = new SuperHero("Clark Kent", "Superman",
                "Super strength, flight, lasers, shit what doesn't he have", false, 1938);
        SuperHero testHero3 = new SuperHero("Johnny",
                "Cool as shit", true, 2000);
        SuperHero testHero4 = new SuperHero("Bruce Wayne", "Bat man",
                "Money", true, 1939);
        db.getHeroDatabase().addAll(Arrays.asList(testHero1, testHero2, testHero3, testHero4));

        //Expected result should be Spider-man, Superman and Bat man
        // man is witg hyphen, no space and spaced for best test
        String testSearchWordNone = "Wonder woman";
        String testSearchWordOne = "Johnny";
        String testSearchWordMany = "man";

        int testListSizeNone = db.searchForHeroList(testSearchWordNone).size();
        int testListSizeOne = db.searchForHeroList(testSearchWordOne).size();
        int testListSizeMany = db.searchForHeroList(testSearchWordMany).size();

        int expectedListSizeNone = 0;
        int expectedListSizeOne = 1;
        int expectedListSizeMany = 3;

        assertAll("Tester nyindsatte helt",
                () -> assertEquals(expectedListSizeNone, testListSizeNone),
                () -> assertEquals(expectedListSizeOne, testListSizeOne),
                () -> assertEquals(expectedListSizeMany, testListSizeMany)
            );
    }
}