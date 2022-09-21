import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {


    Database db = new Database();
    SuperHero defaultHero;

    @BeforeEach
    void setUp() {
        //Har egentlig bare denne her for at prøve BeforeEach af
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
        //Arrange
        int expectedListSize = 5;
        int expectedIndexForGreenLantern = 4;
        //Act
        db.addToDatabase("John Stewart", "Green Lantern", "Green lantern ring", true, 1971);
        String expectedNameGreenLantern = "Green Lantern";
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
        //Act
        //Hvis der er mellemrum i navnet "Luke Cage " så virker equals ikke. Hvordan kan man tage højde for det?
        db.addToDatabase("Luke Cage", "Super strength, ", true, 1972);
        String expectedNameLukeCage = "Luke Cage";
        //Assert
        assertAll("Tester nyindsatte helt",
                () -> assertEquals(expectedListSize, db.getHeroDatabase().size()),
                () -> assertEquals(expectedNameLukeCage, db.getHeroDatabase().get(expectedIndexForLukeCage).getName())
        );
    }

    @Test
    void searchForHeroList() {

        //arrange
        int expectedListSizeNone = 0;
        int expectedListSizeOne = 1;
        int expectedListSizeMany = 3;
        //Act
        //Expected result should be Spider-man, Superman and Bat man
        // man is spelled with hyphen, no space and spaced for best test
        String testSearchWordNone = "Wonder woman";
        String testSearchWordOne = "Johnny";
        String testSearchWordMany = "man";
        //Assert
        //searchForHeroList returnerer en arrayliste ud fra hvor mange objekter den kan finde med det valgte søgeord.
        int testListSizeNone = db.searchForHeroList(testSearchWordNone).size();
        int testListSizeOne = db.searchForHeroList(testSearchWordOne).size();
        int testListSizeMany = db.searchForHeroList(testSearchWordMany).size();

        assertAll("Tester nyindsatte helte for 0, 1 og 3 helte som er fundet",
                () -> assertEquals(expectedListSizeNone, testListSizeNone),
                () -> assertEquals(expectedListSizeOne, testListSizeOne),
                () -> assertEquals(expectedListSizeMany, testListSizeMany)
        );
    }

    @Test
    void deleteHeroFirstTry() {
        //Arrange
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

