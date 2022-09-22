import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {


    Database db = new Database();

    @BeforeEach
    void setUp() {
        //Opretter og tilføjer helte til databasen så det ikke skal gøres i hver test metode
        SuperHero testHero1 = new SuperHero("Peter Parker", "Spider-man",
                "Spider stuff", true, 1962);
        SuperHero testHero2 = new SuperHero("Clark Kent", "Superman",
                "Super strength, flight, lasers, shit what doesn't he have", false, 1938);
        SuperHero testHero3 = new SuperHero("Johnny",
                "Cool as shit", true, 2000);
        SuperHero testHero4 = new SuperHero("Bruce Wayne", "Batman",
                "Money", true, 1939);
        //indsætter til databasen
        db.getHeroDatabase().addAll(Arrays.asList(testHero1, testHero2, testHero3, testHero4));
    }


    @Test
    void addToDatabaseWithHeroName() {
        //Tester addToDatabase, så bruger metoden frem for general arraylist metode som i void setup()

        //Arrange
        int expectedListSize = 5;
        int expectedIndexForGreenLantern = 4;
        String expectedNameGreenLantern = "Green Lantern";

        //Act
        db.addToDatabase("John Stewart", "Green Lantern", "Green lantern ring", true, 1971);

        //Assert
        assertAll("Tester nyindsatte helt",
                () -> assertEquals(expectedListSize, db.getHeroDatabase().size()),
                () -> assertEquals(expectedNameGreenLantern, db.getHeroDatabase().get(expectedIndexForGreenLantern).getSuperheroName())
        );
    }

    @Test
    void addToDatabaseWithoutHeroName() {
        //Arrange
        int expectedListSize = 5;
        int expectedIndexForLukeCage = 4;
        String expectedNameLukeCage = "Luke Cage";

        //Act
        //Hvis der er mellemrum i navnet "Luke Cage " så virker equals ikke. Hvordan kan man tage højde for det?
        db.addToDatabase("Luke Cage", "Super strength, ", true, 1972);

        //Assert
        assertAll("Tester nyindsatte helt",
                () -> assertEquals(expectedListSize, db.getHeroDatabase().size()),
                () -> assertEquals(expectedNameLukeCage, db.getHeroDatabase().get(expectedIndexForLukeCage).getName())
        );
    }

    @Test
    void searchForHeroList() {
        //tester search for hero list. Tester for søgning giver 0, 1 og 3 resultater.

        //arrange
        //Expected result should be Spider-man, Superman and Bat man
        // man is spelled with hyphen, no space and spaced for best test
        int expectedListSizeNone = 0;
        int expectedListSizeOne = 1;
        int expectedListSizeMany = 3;

        String testSearchWordNone = "Wonder woman";
        String testSearchWordOne = "Johnny";
        String testSearchWordMany = "man";

        //Act
        //searchForHeroList returnerer en arrayliste ud fra hvor mange objekter den kan finde med det valgte søgeord.
        int testListSizeNone = db.searchForHeroList(testSearchWordNone).size();
        int testListSizeOne = db.searchForHeroList(testSearchWordOne).size();
        int testListSizeMany = db.searchForHeroList(testSearchWordMany).size();


        //Assert
        assertAll("Tester nyindsatte helte for 0, 1 og 3 helte som er fundet",
                () -> assertEquals(expectedListSizeNone, testListSizeNone),
                () -> assertEquals(expectedListSizeOne, testListSizeOne),
                () -> assertEquals(expectedListSizeMany, testListSizeMany)
        );
    }

    @Test
    void deleteHeroFirstTry() {
        //Har først skrevet logikken her og testet før jeg lavede den i databasen.

        //Arrange
        //Tester at Clark Kent ender i index 0
        int expectedValueAfterDeletion = 3;
        String expectedNameOfNewIndex0 = "Clark Kent";

        //Act
        //Simuler at man modtager inputtet 1 fra brugeren og omdanner den til index 0.
        db.getHeroDatabase().remove(1 - 1);

        //Assert
        assertAll("Tester om Spider-man er slettet og at Superman nu står i første index (0)",
                () -> assertEquals(expectedValueAfterDeletion, db.getHeroDatabase().size()),
                () -> assertEquals(expectedNameOfNewIndex0, db.getHeroDatabase().get(0).getName())
        );
    }

    @Test
    void deteHeroMethod() {
        //Arrange
        int expectedValueAfterDeletion = 3;
        String expectedNameOfNewIndex0 = "Clark Kent";

        //Act
        //Simuler at man modtager inputtet 1 fra brugeren og omdanner den til index 0.
        //Nu skal det gøres inden i metoden, dette testes
        db.deleteHero(1);
        //Assert

        assertAll("Tester om Spider-man er slettet og at Superman nu står i første index (0)",
                () -> assertEquals(expectedValueAfterDeletion, db.getHeroDatabase().size()),
                () -> assertEquals(expectedNameOfNewIndex0, db.getHeroDatabase().get(0).getName())
        );
    }
}

