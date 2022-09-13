import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    ArrayList<SuperHero> heroDatabase = new ArrayList<>();
    int n;

    Scanner sc;

    public Database() {
        ArrayList<SuperHero> heroList = new ArrayList<>();
        n = 0;
    }

    public ArrayList<SuperHero> getHeroDatabase() {
        return heroDatabase;
    }

    public void setHeroDatabase(ArrayList<SuperHero> heroDatabase) {
        this.heroDatabase = heroDatabase;
    }

    public void addToDatabase(String name, String superheroName, String superheroPower, boolean human, int creationYear) {
            heroDatabase.add(new SuperHero(name, superheroName, superheroPower, human, creationYear));
            n++;
    }

    public void addToDatabase(String name, String superheroPower, boolean human, int creationYear) {
            heroDatabase.add(new SuperHero(name, superheroPower, human, creationYear));
            n++;
    }

    public void createAndAddHero() {
        if(n>heroDatabase.size()){
            System.out.println("Kan ikke tilføje flere helte");
        }
        else {
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
    }
}



