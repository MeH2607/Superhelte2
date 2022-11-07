package Data;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {


    public ArrayList<SuperHero> readFile() {
        ArrayList<SuperHero> heroListFile = new ArrayList<SuperHero>();
        try {
            Scanner sc = new Scanner(new File("SuperHeroDatabase.csv"));

            while (sc.hasNextLine()) {
                String linje = sc.nextLine();
                String[] attributes = linje.split(",");
                SuperHero s = new SuperHero(
                        attributes[0],
                        heroNameToNull(attributes[1]),
                        attributes[2],
                        Boolean.parseBoolean(attributes[3]),
                        Integer.parseInt(attributes[4]));
                heroListFile.add(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return heroListFile;
    }

    public void writeToFile(ArrayList<SuperHero> list) {
        try {
            PrintStream out = new PrintStream(new File("SuperHeroDatabase.csv"));
            for (SuperHero s : list) {
                out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
        private String heroNameToNull(String heroName){
        if(heroName.equals("null")){
            return null;
        }
        return heroName;
        }
}
