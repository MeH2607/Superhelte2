import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    private Controller controller = new Controller();

    //TODO lav lokale arraylister i hjælpe metoderne, så man ikke henter databasen flere gange
    // hvis databasen ikke er tom.


    public void startProgram() {
        controller.initialLoad();

        int menuValg = 0;

        System.out.println("Velkommen til Superhelte databasen\n");
        do {
            System.out.println("""
                    Hvad vil du gøre?
                    1. Opret superhelt
                    2. Vis alle helte
                    3. Søg på helte
                    4. Rediger helte info
                    5. Slet helt
                    9. afslut
                    """);

            menuValg = readInt();


            switch (menuValg) {
                case 1:
                    createAndAddHeroLocalMethod();
                    break;
                case 2:
                    showAllHeroesLocalMethod();
                    break;
                case 3:
                    findHeroListLocalMethod();
                    break;
                case 4:
                    editHeroLocalMethod();
                    break;
                case 5:
                    deleteHeroLocalMethod();
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


    private void createAndAddHeroLocalMethod() {
        System.out.println("* Tilføj en superhelt *");

        System.out.println("\nTilføj deres civil navn: ");
        String name = sc.nextLine();

        System.out.println("\nHar de et heltenavn?\n1. ja\n0. nej");
        int svar = sc.nextInt();
        sc.nextLine(); //Til scannerbug
        String heroName = null;
        if (svar == 1) {
            System.out.println("\nTilføj deres heltenavn: ");
            heroName = sc.nextLine();
        }

        System.out.println("\nTilføj deres superstyrke: ");
        String heroPower = sc.nextLine();

        System.out.println("\nEr de et menneske?");
        boolean isHuman = true;
        int valg;
        do {
            System.out.println("\nTast 1 for ja\nTast 2 for nej");
            valg = sc.nextInt();
            switch (valg) {
                case 1:
                    isHuman = true;
                    break;
                case 2:
                    isHuman = false;
                    break;
                default:
                    System.out.println("ugyldigt input, prøv igen");
            }
        } while (valg != 1 && valg != 2);

        //Scannerbug :(
        sc.nextLine();

        System.out.println("\nHvornår blev de lavet: ");
        int year = readInt();

        //Tjekker om de har et superheltenavn og opretter så hero objekter
        if (heroName == null) {
            controller.createAndAddHero(name, heroPower, isHuman, year);
            controller.writeToFile(controller.getHeroDatabase());
            System.out.println("\nDu har tilføjet " + name + " til databasen.\n");
        } else {
            controller.createAndAddHero(name, heroName, heroPower, isHuman, year);
            controller.writeToFile(controller.getHeroDatabase());
            System.out.println("\nDu har tilføjet " + name + " også kendt som " + heroName + " til databasen.\n");
        }
    }

    private void showAllHeroesLocalMethod() {
        ArrayList<SuperHero> localHeroList = controller.getHeroDatabase();

        if (localHeroList.isEmpty()) {
            System.out.println("Ingen helte i databasen");
        } else {
            for (SuperHero h : localHeroList) {
                System.out.println("Civilnavn : " + h.getName());
                if (h.getSuperheroName() == null) {
                    System.out.println("\nIntet heltenavn");
                } else {
                    System.out.println("Superheltenavn: " + h.getSuperheroName());
                }
                if (h.isHuman() == true) {
                    System.out.println("\nMenneske?: Ja");
                } else {
                    System.out.println("\nMenneske?: Nej");
                }
                System.out.println("\nSuperstyrke: " + h.getSuperheroPower());
                System.out.println("\nOprindelsesår: " + h.getCreationYear() + "\n\n");
            }
        }
    }

    private void findHeroListLocalMethod() {
        String searchName;
        System.out.println("* Søg efter Superhelt *");
        searchName = sc.nextLine();
        ArrayList<SuperHero>localHeroList = controller.searchForHeroList(searchName);

        for (SuperHero h : localHeroList) {
            if (h != null) {
                String name = h.getName();
                String superHeroName = " ";
                String isHuman = " ";
                String superStyrke = h.getSuperheroPower();
                int creationYear = h.getCreationYear();

                if (h.getSuperheroName() == null) {
                    superHeroName = "Intet heltenavn";
                } else {
                    superHeroName = h.getSuperheroName();
                }

                if (h.isHuman() == true) {
                    isHuman = "Ja";
                } else {
                    isHuman = "Nej";
                }

                System.out.printf("""
                        Civilnavn: %s
                        Superheltenavn: %s
                        Menneske?: %s
                        Superstyrke: %s
                        Oprindelsesår: %d
                        
                        """, name, superHeroName, isHuman, superStyrke, creationYear);

            }
        }
        if (localHeroList.isEmpty()) {
            System.out.println("Ingen helte med navnet " + searchName + "\n");
        }
    }

    private void editHeroLocalMethod() {
        //If løkken sender en besked hvis listen er tom
        ArrayList<SuperHero> localHeroList = controller.getHeroDatabase();
        if (localHeroList.isEmpty()) {
            System.out.println("Ingen helte i databasen");
        } else {
            //Printer alle helte ud med deres plads nummer
            System.out.println("Vælg helt der skal redigeres: \n");
            for (SuperHero h : localHeroList) {
                System.out.println(localHeroList.indexOf(h) + 1 + ". " + h.getName());
            }

            int input1 = readInt();
            SuperHero hero = localHeroList.get(input1 - 1);

            int input2;
            do {
                System.out.println("""
                        Hvad vil du redigere?
                        1. Navn
                        2. Heltenavn
                        3. Superkraft
                        4. Menneskelig
                        5. Udgivelsesår
                        9. Vend tilbage til menuen""");
                input2 = readInt();
                sc.nextLine();
                switch (input2) {
                    case 1:
                        System.out.println("Rediger " + hero.getName() + " eller tryk enter for at fortryde");
                        String newName = sc.nextLine();
                        if (!newName.isEmpty()) {
                            hero.setName(newName);
                        }
                        break;
                    case 2:
                        System.out.println("Rediger " + hero.getSuperheroName() + " eller tryk enter for at fortryde");
                        String newHeroName = sc.nextLine();
                        if (!newHeroName.isEmpty()) {
                            hero.setName(newHeroName);
                        }
                        break;
                    case 3:
                        System.out.println("Rediger " + hero.getSuperheroPower() + " eller tryk enter for at fortryde");
                        String newPower = sc.nextLine();
                        if (!newPower.isEmpty()) {
                            hero.setSuperheroPower(newPower);
                        }
                        break;
                    case 4:
                        System.out.println("\nEr" + hero.getName() + " et menneske?");
                        int valg2;
                        do {
                            System.out.println("\nTast 1 for ja\nTast 2 for nej");
                            valg2 = readInt();
                            switch (valg2) {
                                case 1:
                                    hero.setHuman(true);
                                    break;
                                case 2:
                                    hero.setHuman(false);
                                    break;
                                default:
                                    System.out.println("ugyldigt input, prøv igen");
                            }
                        } while (valg2 != 1 && valg2 != 2);
                        break;
                    case 5:
                        System.out.println("Rediger " + hero.getCreationYear() + " eller tryk enter for at fortryde");
                       //TODO til mohamed, test dette stykke kode
                        int newYear = 0;
                        newYear = readInt();
                        if (newYear == 0) {
                            hero.setCreationYear(newYear);
                        }
                        break;
                    case 9:
                        System.out.println("Vender tilbage");
                        break;
                    default:
                        System.out.println("Ugyldig valg, prøv igen");
                }
            }
            while (input2 != 9);
        }
    }

    private void deleteHeroLocalMethod() {
        //If løkken sender en besked hvis listen er tom
        ArrayList<SuperHero> localHeroList = controller.getHeroDatabase();
        if (localHeroList.isEmpty()) {
            System.out.println("Ingen helte i databasen");
        } else {
            //Printer alle helte ud med deres plads nummer
            System.out.println("Vælg helt der skal slettes: \n");
            for (SuperHero hero : localHeroList) {
                System.out.println(localHeroList.indexOf(hero) + 1 + ". " + hero.getName());
            }

            //Modtager bruger input for hvem der skal slettes og en advarsel.
            int v1 = readInt();
            SuperHero heroToDelete = localHeroList.get(v1-1);
            System.out.println("Er du sikker på de vil slette " + heroToDelete.getName() +
                    "?\n1. Slet " + heroToDelete.getName() + "\n2. Fortryd");

            int v2 = readInt();
            switch (v2) {
                case 1:
                    controller.deleteHero(v1);
                case 2:
                    System.out.println("Vender tilbage");
                    break;
                default:
                    System.out.println("Ugyldig input");
                    break;
            }
        }
    }

    // læser dit input og gentager løkken indtil du inputter en int.
    public int readInt() {
        while (!sc.hasNextInt()) {
            String text = sc.next();
            System.out.println(text + " er ugyldig input, indtast igen.");
        }
        int result;
        result = sc.nextInt();
        sc.nextLine();
        return result;
    }
}





