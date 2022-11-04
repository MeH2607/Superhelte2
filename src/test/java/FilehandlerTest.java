import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FilehandlerTest {

    Database db = new Database();
    Scanner sc;
    PrintStream output;



    @BeforeEach
    void setUp() throws FileNotFoundException {
        //Opretter og tilføjer helte til databasen så det ikke skal gøres i hver test metode
        SuperHero testHero1 = new SuperHero("Peter Parker", "Spider-man",
                "Spider stuff", true, 1962);
        SuperHero testHero2 = new SuperHero("Clark Kent", "Superman",
                "Super everything", false, 1938);
       /* SuperHero testHero3 = new SuperHero("Johnny",
                "Cool as shit", true, 2000);*/
        SuperHero testHero4 = new SuperHero("Bruce Wayne", "Batman",
                "Money", true, 1939);
        SuperHero testHero5 = new SuperHero("Groot",
                "Strong tree", false, 2014);

        //indsætter til databasen
        db.getHeroDatabase().addAll(Arrays.asList(testHero1, testHero2,/* testHero3,*/ testHero4, testHero5));

        {
            try {
                output = new PrintStream("testDatabase.csv");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        sc = new Scanner(new File("testDatabase.csv"));
        try {
            saveSuperHeroesToFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void readSuperHeroesFromFile() throws FileNotFoundException{
        ArrayList<SuperHero> testListFromFile = new ArrayList<>();
        int expectedSizeOfList = 4;

        while(sc.hasNextLine()){
            String linje = sc.nextLine();
            String [] attributes = linje.split(",");
            SuperHero hero = new SuperHero(
                    attributes[0],
                    attributes[1],
                    attributes[2],
                    Boolean.parseBoolean(attributes[3]),
                    Integer.parseInt(attributes[4]));
            testListFromFile.add(hero);

        }
        int listSize = testListFromFile.size();
        System.out.println(testListFromFile.toString());

        assertEquals(expectedSizeOfList, listSize);
    }

    @Test
    void saveSuperHeroesToFile() throws FileNotFoundException {
        ArrayList<SuperHero> outputList = new ArrayList<>();
        int expectedListSiize = 4;

        for(SuperHero hero : db.getHeroDatabase()){
            output.print(hero.toString());
            outputList.add(hero);
        }
        output.close();
// testet ved at tjekke outputtet i testDatabase.csv

        assertEquals(expectedListSiize, outputList.size());
    }

}