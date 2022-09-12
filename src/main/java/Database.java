import java.util.Scanner;

public class Database {
    SuperHero[] heroDatabase = new SuperHero[10];
    int n;

    Scanner sc = new Scanner(System.in);

    public Database() {
        SuperHero[] database = new SuperHero[10];
        n = 0;
    }

    public void addToDatabase(String name, String superheroName, String superheroPower, boolean human, int creationYear) {
        heroDatabase[n] = new SuperHero(name, superheroName, superheroPower, human, creationYear);
    }

    public void addToDatabase(String name, String superheroPower, boolean human, int creationYear) {
        heroDatabase[n] = new SuperHero(name, superheroPower, human, creationYear);
    }

    public void makeAndAddHero() {
        System.out.println("Tilføj en superhelt: ");

        System.out.println("\nCivil navn: ");
        String name = sc.nextLine();


        System.out.println("\nHar de et heltenavn? 1 for ja, 0 for nej");
        int svar = sc.nextInt();
        sc.nextLine();
        String heroName = null;
        if (svar == 1) {
            System.out.println("\nTilføj heltenavn: ");
            heroName = sc.nextLine();
        }
        System.out.println("\nTilføj superstyrke: ");
        String heroPower = sc.nextLine();

        System.out.println("\nEr de et menneske?");
        boolean isHuman = true;
        int valg;
        do {
            //todo insæt switch istedet
            System.out.println("\nTast 1 for ja\nTast 2 for nej");
            valg = sc.nextInt();
            sc.nextLine();
            if (valg == 1) {
                isHuman = true;
            } else if (valg == 2) {
                isHuman = false;
            } else System.out.println("Prøv igen.");
        } while (valg != 1 && valg != 2);


        System.out.println("\nHvornår blev de lavet: ");
        int year = sc.nextInt();

        //Tjekker om de har et superheltenavn og opretter så hero objekter
        if (heroName == null) {
            addToDatabase(name, heroPower, isHuman, year);
         //   SuperHero hero = new SuperHero(name, heroPower, isHuman, year);
            System.out.println("Du har tilføjet " + name + " til databasen.");
        } else {
            addToDatabase(name, heroName, heroPower, isHuman, year);
          //  SuperHero hero = new SuperHero(name, heroName, heroPower, isHuman, year);
            System.out.println("Du har tilføjet " + name + " også kendt som " + heroName + " til databasen.");
        }
    }
}

