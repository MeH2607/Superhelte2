import comparator.HeroNameComparator;
import comparator.NameComparator;
import domain.Database;
import domain.SuperHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
        SuperHero testHero3 = new SuperHero("Johnny", null,
                "Cool as shit", true, 2000);
        SuperHero testHero4 = new SuperHero("Bruce Wayne", "Batman",
                "Money", true, 1939);
        SuperHero testHero5 = new SuperHero("Peter Parker", "Spider-man", "Spider stuff", true, 1999);
        //indsætter til databasen
        db.getHeroDatabase().addAll(Arrays.asList(testHero1, testHero2, testHero3, testHero4, testHero5));
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
        db.addToDatabase("Luke Cage", null, "Super strength, ", true, 1972);

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

    @Test
    public void sortByHeroNameTest() {
        ArrayList<SuperHero> heroTestList = db.getHeroDatabase();


        Collections.sort(heroTestList, new HeroNameComparator());


        assertTrue(heroTestList.get(4).getSuperheroName() == null);
        assertTrue(heroTestList.get(3).getSuperheroName() == null);
    }

    @Test
    public void primaryAndSecondaryTheSame() {
        ArrayList<SuperHero> heroTestList = db.getHeroDatabase();


        Collections.sort(heroTestList, new HeroNameComparator().thenComparing(new HeroNameComparator()));

        assertEquals("Bruce Wayne", heroTestList.get(0).getName());
    }

    @Test
    public void primaryAndSecondaryNotTheSame() {
        Comparator c1;
        Comparator c2;
        boolean b = false;

        c1 = new NameComparator();
        c2 = new NameComparator();

        if (c1.getClass().equals(c2.getClass())) {
            b = true;
        }
        ;

        System.out.println(c1.getClass());
        assertTrue(b);

    }

    @Test
    public void primarySecondarySortingDifferentComparator() {
        int nameCompare = 1;
        int yearCompare = 5;

        ArrayList<SuperHero> sortedList = db.sortByPrimarySecondary(nameCompare, yearCompare);

        assertEquals(1962, sortedList.get(3).getCreationYear());
        assertEquals(1999, sortedList.get(4).getCreationYear());

    }

    @Test
    public void primarySecondarySortingSameComparator() {
        int nameCompare = 1;

        assertThrows(IllegalArgumentException.class, () -> {
            db.sortByPrimarySecondary(nameCompare, nameCompare);
        });

    }


}

