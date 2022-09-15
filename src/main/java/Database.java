import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Database {
   // ArrayList<SuperHero> heroDatabase = new ArrayList<>();

    SuperHero s1 = new SuperHero("Clark kent", "Superman", "Super styrke",false,1925);
    SuperHero s2 = new SuperHero("Bruce Wayne", "Batman", "money", true, 1939);
    SuperHero s3 = new SuperHero("Johnny", "Cool as fuck",true, 2000);
    SuperHero s4 = new SuperHero("Saitama", "Super strength", true, 2009);

    ArrayList<SuperHero> heroDatabase = new ArrayList<>(Arrays.asList(s1,s2,s3,s4));

    ArrayList<SuperHero>findSuperheroList;

    Scanner sc;

    public Database() {
        ArrayList<SuperHero> heroDatabase;
    }

    public ArrayList<SuperHero> getHeroDatabase() {
        return heroDatabase;
    }

    public void addToDatabase(String name, String superheroName, String superheroPower, boolean human, int creationYear) {
            heroDatabase.add(new SuperHero(name, superheroName, superheroPower, human, creationYear));
    }

    public void addToDatabase(String name, String superheroPower, boolean human, int creationYear) {
            heroDatabase.add(new SuperHero(name, superheroPower, human, creationYear));
    }

/*    public SuperHero createAndAddHero(String name, String superheroName, String superheroPower, boolean human, int creationYear) { //TODO lav denne kode om til ikke at printe, kun tilføje. Meget simpel metode
            sc = new Scanner(System.in);
            System.out.println("Tilføj en superhelt: ");
            //I tilfælde af scannerbug


            System.out.println("\nTilføj deres civil navn: ");
            String name = sc.nextLine();

            System.out.println("\nHar de et heltenavn?\n1. ja\n0. nej");
            int svar = sc.nextInt();
            sc.nextLine();
            String heroName = null;
            if (svar == 1) {
                System.out.println("\nTilføj deres heltenavn: ");
                heroName = sc.nextLine();
            }

            System.out.println("\nTilføj deres superstyrke: ");
            String heroPower = sc.nextLine();

            System.out.println("\nEr de et menneske?");
            boolean isHuman = true;
            int valg2;
            do {
                System.out.println("\nTast 1 for ja\nTast 2 for nej");
                valg2 = sc.nextInt();
                switch (valg2) {
                    case 1:
                        isHuman = true;
                        break;
                    case 2:
                        isHuman = false;
                        break;
                    default:
                        System.out.println("ugyldigt input, prøv igen");
                }
            }
            while (valg2 != 1 && valg2 != 2);

            //Scannerbug
            sc.nextLine();

            System.out.println("\nHvornår blev de lavet: ");
            int year = sc.nextInt();

            //Tjekker om de har et superheltenavn og opretter så hero objekter
            if (heroName == null) {
                addToDatabase(name, heroPower, isHuman, year);
                //   SuperHero hero = new SuperHero(name, heroPower, isHuman, year);
                System.out.println("\nDu har tilføjet " + name + " til databasen.\n");
            } else {
                addToDatabase(name, heroName, heroPower, isHuman, year);
                //  SuperHero hero = new SuperHero(name, heroName, heroPower, isHuman, year);
                System.out.println("\nDu har tilføjet " + name + " også kendt som " + heroName + " til databasen.\n");
            }
        }*/


    public SuperHero searchForHero(String searchName){
        for (SuperHero hero : heroDatabase){
            //to if løkker hvis man vil søge via superheltenavn og almindelig navn
            if(hero.getName().toLowerCase().contains(searchName.toLowerCase())){
                return hero;
            }
            //Første del i tilfælde af at superheroName er null og så ikke prøver at gøre null lowercase og crash
            else if(hero.getSuperheroName() != null && hero.getSuperheroName().contains(searchName.toLowerCase())){
                return hero;
            }
        }
        System.out.println("Kunne ikke finde " + searchName);
        return null;
    }

    //Samler en gruppe af helte, når man skal gemme resultater. Bruges til når der skal redigeres.
    public ArrayList<SuperHero> searchForHeroList(String searchName){
        for (SuperHero hero : heroDatabase){
            if(hero.getName().toLowerCase().contains(searchName.toLowerCase())){
                findSuperheroList.add(hero);
            }
            else if(hero.getSuperheroName() != null && hero.getSuperheroName().contains(searchName.toLowerCase())){
                findSuperheroList.add(hero);
            }
        }
        return null;
    }

}




