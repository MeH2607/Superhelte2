import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database db = new Database();


    @Test
    void addToDatabase() {
        //todo Sammenlign navnet på testHero
        SuperHero testHero = new SuperHero("Spider-man", "Peter Parker",
                "Spider stuff", true, 1960);
        db.getHeroDatabase().add(testHero);
        int expectedListSize = 1;
        assertEquals(expectedListSize, db.getHeroDatabase().size());
    }

    @Test
    void testAddToDatabase() {
    }

    @Test
    void searchForHero() {
    }

    @Test
    void searchForHeroList() {
    }
}