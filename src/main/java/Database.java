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

    Scanner sc;

    public Database() {
        ArrayList<SuperHero> heroList = new ArrayList<>();
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

    public void createAndAddHero() {
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
        }


    public void searchOfHero(String searchName){
        Boolean find = false;
        for (SuperHero hero : heroDatabase){
            if(hero.getName().toLowerCase().contains(searchName.toLowerCase()) || hero.getSuperheroName().toLowerCase().contains(searchName.toLowerCase())){
                System.out.println("Civilnavn : " + hero.getName() + "\n\nHeltenavn: " + hero.getSuperheroName() + "\n");
                if (hero.isHuman() == true) {
                    System.out.println("\nMenneske?: Ja");
                } else {
                    System.out.println("\nMenneske?: Nej");
                }
                System.out.println("\nSuperstyrke: " + hero.getSuperheroPower());
                System.out.println("\nOprindelsesår: " + hero.getCreationYear() + "\n");
                find = true;
            }
        }
        if(!find){
            System.out.println("Kan ikke finde helte med " + searchName + " i navnet.\n");
        }
    }

}




