
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private Database database = new Database();
    Scanner sc;


    public void startProgram() {
        sc = new Scanner(System.in);
        int menuValg = 0;

        System.out.println("Velkommen til Superhelte databasen\n");
        do {
            System.out.println("""
                    Hvad vil du gøre?
                    1. Opret superhelt
                    2. Vis alle helte
                    3. Søg på helte
                    4. Rediger helte info
                    9. afslut
                    """);

            //  menuValg = readInt();
            boolean wrongUserInput = true;
            while (wrongUserInput) {
                try {
                    menuValg = sc.nextInt();
                    wrongUserInput = false;
                } catch (InputMismatchException e) {
                    System.out.println("Ugyldig input, prøv igen");
                    sc.nextLine(); //til scannerbug gottemggs
                }
            }

            switch (menuValg) {
                case 1:
                    createAndAddHero();
                    break;
                case 2:
                    showAllHeroes();
                    break;
                case 3:
                    findHeroList();
                    break;
                case 4:
                    editHero();
                    break;
                case 9:
                    System.out.println("\nPå gensyn");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ugyldigt valg");
                    break;
            }
        } while (menuValg != 9);
    }


    private void createAndAddHero() { //TODO lav denne kode om til ikke at printe, kun tilføje. Meget simpel metode
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
        } while (valg2 != 1 && valg2 != 2);

        //Scannerbug
        sc.nextLine();

        System.out.println("\nHvornår blev de lavet: ");
        int year = sc.nextInt();

        //Tjekker om de har et superheltenavn og opretter så hero objekter
        if (heroName == null) {
            database.addToDatabase(name, heroPower, isHuman, year);
            //   SuperHero hero = new SuperHero(name, heroPower, isHuman, year);
            System.out.println("\nDu har tilføjet " + name + " til databasen.\n");
        } else {
            database.addToDatabase(name, heroName, heroPower, isHuman, year);
            //  SuperHero hero = new SuperHero(name, heroName, heroPower, isHuman, year);
            System.out.println("\nDu har tilføjet " + name + " også kendt som " + heroName + " til databasen.\n");
        }
    }

    private void showAllHeroes() {
        for (SuperHero hero : database.getHeroDatabase()) {
            System.out.println("Civilnavn : " + hero.getName());
            if (hero.getSuperheroName() == null) {
                System.out.println("\nIntet heltenavn");
            } else {
                System.out.println("Superheltenavn: " + hero.getSuperheroName());
            }
            if (hero.isHuman() == true) {
                System.out.println("\nMenneske?: Ja");
            } else {
                System.out.println("\nMenneske?: Nej");
            }
            System.out.println("\nSuperstyrke: " + hero.getSuperheroPower());
            System.out.println("\nOprindelsesår: " + hero.getCreationYear() + "\n\n");
        }
    }


    private void findHero() {
        String name;
        System.out.println("Søg efter Superhelt ");
        name = sc.next();
        SuperHero hero;

        //for (SuperHero hero : database.getHeroDatabase()){
        hero = database.searchForHero(name);
        if (hero != null) {
            System.out.println("Civilnavn : " + hero.getName());
            if (hero.getSuperheroName() == null) {
                System.out.println("\nIntet heltenavn");
            } else {
                System.out.println("\nSuperheltenavn: " + hero.getSuperheroName());
            }
            if (hero.isHuman() == true) {
                System.out.println("\nMenneske?: Ja");
            } else {
                System.out.println("\nMenneske?: Nej");
            }
            System.out.println("\nSuperstyrke: " + hero.getSuperheroPower());
            System.out.println("\nOprindelsesår: " + hero.getCreationYear() + "\n\n");
        }
        // }

    }


    private void findHeroList() {
        String name;
        System.out.println("Søg efter Superhelt ");
        name = sc.next();
        for (SuperHero hero : database.searchForHeroList(name)) {
            if (hero != null) {
                System.out.println("Civilnavn : " + hero.getName());
                if (hero.getSuperheroName() == null) {
                    System.out.println("\nIntet heltenavn");
                } else {
                    System.out.println("\nSuperheltenavn: " + hero.getSuperheroName());
                }
                if (hero.isHuman() == true) {
                    System.out.println("\nMenneske?: Ja");
                } else {
                    System.out.println("\nMenneske?: Nej");
                }
                System.out.println("\nSuperstyrke: " + hero.getSuperheroPower());
                System.out.println("\nOprindelsesår: " + hero.getCreationYear() + "\n\n");
            }
        }
        if(database.getFindSuperheroList().isEmpty()){
            System.out.println("Ingen helte med navnet " + name + "\n");
        }
    }

        private void editHero () {
            //Printer alle helte ud med deres plads nummer
            System.out.println("Vælg helt der skal redigeres: \n");
            for (SuperHero hero : database.getHeroDatabase()) {
                System.out.println(database.getHeroDatabase().indexOf(hero) + 1 + ". " + hero.getName());
            }

            int v1 = sc.nextInt();
            SuperHero hero = database.getHeroDatabase().get(v1 - 1);
            System.out.println("""
                    Hvad vil du redigere?
                    1. Navn
                    2. Heltenavn
                    3. Superkraft
                    4. Menneskelig
                    5. Udgivelsesår""");
            int v2 = sc.nextInt();
            switch (v2) {
                case 1:
                    System.out.println("Rediger " + hero.getName());
                    String newName = sc.nextLine();
                    if (!newName.isEmpty()) {
                        hero.setName(newName);
                    }
            }
        }

        public int readInt () {
            while (!sc.hasNextInt()) {
                String text = sc.next();
                System.out.println(text + " er ugyldig input, indtast igen.");
            }
            int result = sc.nextInt();
            return result;
        }
    }




