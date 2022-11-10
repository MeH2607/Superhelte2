package userInterface;

import domain.Controller;
import domain.SuperHero;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    private Controller controller = new Controller();


    public void startProgram() {
        controller.initialLoad();

        int menuValg = 0;

        System.out.println("Velkommen til Superhelte databasen\n");
        do {
            menuPrint();

            menuValg = readInt();

            switch (menuValg) {
                case 1 -> createHero();
                case 2 -> showAllHeroes();
                case 3 -> findHeroList();
                case 4 -> editHero();
                case 5 -> deleteHero();
                case 6 -> sortingMenu();
                case 9 -> System.out.println("\nPå gensyn");
                default -> System.out.println("Ugyldigt valg");
            }
        } while (menuValg != 9);
        takMohamed();
        //Useless (tak Mohamed)
        System.exit(0);
    }


    private void createHero() {
        System.out.println("* Tilføj en superhelt *");

        System.out.println("\nTilføj deres civil navn: ");
        String name = sc.nextLine();

        System.out.println("\nHar de et heltenavn?\n1. ja\n0. nej");
        int svar = sc.nextInt();
        sc.nextLine(); //Til scannerbug
        String heroName = null;
        do {
            switch (svar) {
                case 1:
                    System.out.println("\nTilføj deres heltenavn: ");
                    heroName = sc.nextLine();
                    break;
                case 2:
                    heroName = null;
                    break;
                default:
                    System.out.println("Ugyldig input");
            }
        } while (svar != 1 || svar != 2);

        System.out.println("\nTilføj deres superstyrke: ");
        String heroPower = sc.nextLine();

        System.out.println("\nEr de et menneske?");
        boolean isHuman = true;
        int valg;
        do {
            System.out.println("\nTast 1 for ja\nTast 2 for nej");
            valg = sc.nextInt();
            switch (valg) {
                case 1 -> isHuman = true;
                case 2 -> isHuman = false;
                default -> System.out.println("ugyldigt input, prøv igen");
            }
        } while (valg != 1 && valg != 2);

        //Scannerbug :(
        sc.nextLine();

        System.out.println("\nHvornår blev de lavet: ");
        int year = readInt();

        controller.createHero(name, heroName, heroPower, isHuman, year);
        System.out.println("\nDu har tilføjet " + name + " til databasen.\n");

    }

    private void showAllHeroes() {

        ArrayList<SuperHero> list = controller.getHeroDatabase();

        if (list.isEmpty()) {
            System.out.println("Ingen helte i databasen");
        } else {
            listHeader();
            for (SuperHero hero : list) {
                System.out.println(formatPrint(hero));
            }
        }
    }

    private void findHeroList() {
        String searchName;
        System.out.println("* Søg efter Superhelt *");
        searchName = sc.nextLine();
        ArrayList<SuperHero> localHeroList = controller.searchForHeroList(searchName);

        for (SuperHero hero : localHeroList) {
            if (hero != null) {
                String name = hero.getName();
                String superHeroName = " ";
                String isHuman = " ";
                String superStyrke = hero.getSuperheroPower();
                int creationYear = hero.getCreationYear();

                if (hero.getSuperheroName() == null) {
                    superHeroName = "Intet heltenavn";
                } else {
                    superHeroName = hero.getSuperheroName();
                }

                if (hero.getIsHuman() == true) {
                    isHuman = "Ja";
                } else {
                    isHuman = "Nej";
                }

                System.out.println(formatPrint(hero));

            }
        }
        if (localHeroList.isEmpty()) {
            System.out.println("Ingen helte med navnet " + searchName + "\n");
        }
    }

    private void editHero() {
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
                        //TODO Ret denne til at modtage tom input for at skippe
                        System.out.println("Rediger " + hero.getCreationYear() + " eller tryk enter for at fortryde");
                        String newYear;
                        newYear = sc.nextLine();
                        if (!newYear.isEmpty()) {
                            hero.setCreationYear(Integer.parseInt(newYear));
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

    private void deleteHero() {
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
            SuperHero heroToDelete = localHeroList.get(v1 - 1);
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

    public void sortByNameLocalMethod() {
        listHeader();
        for (SuperHero hero : controller.sortByName()) {
            System.out.println(formatPrint(hero));
        }
    }

    public void sortByHeroPowerLocalMethod() {
        listHeader();
        for (SuperHero hero : controller.sortBySuperHeroPower()) {
            System.out.println(formatPrint(hero));
        }
    }

    public void sortByYearLocalMethod() {
        listHeader();
        for (SuperHero hero : controller.sortByCreationYear()) {
            System.out.println(formatPrint(hero));
        }
    }

    public void sortByIsHumanLocalMethod() {
        listHeader();
        for (SuperHero hero : controller.sortByHuman()) {
            System.out.println(formatPrint(hero));
        }
    }

    public void sortByHeroNameLocalMethod() {
        listHeader();
        for (SuperHero hero : controller.sortByHeroName()) {
            System.out.println(formatPrint(hero));
        }
    }

    private void sortByPrimarySecondaryMethod() {
        int menuValg = 0;
        int valg1 = 0;
        int valg2 = 0;

        System.out.println("Vælg primære sorteringskriterie\n");
        System.out.println("""
                1. Navn
                2. Heltenavn
                3. Superkraft
                4. Er menneske
                5. Oprindelses år
                9. afslut
                """);
        menuValg = readInt();
        switch (menuValg) {
            case 1 -> valg1 = 1;
            case 2 -> valg1 = 2;
            case 3 -> valg1 = 3;
            case 4 -> valg1 = 4;
            case 5 -> valg1 = 5;
            default -> System.out.println("Ugyldig input");
        }
        System.out.println("Vælg sekundære sorteringskriterie\n");
        System.out.println("""
                1. Navn
                2. Heltenavn
                3. Superkraft
                4. Er menneske
                5. Oprindelses år
                9. afslut
                """);
        menuValg = readInt();
        switch (menuValg) {
            case 1 -> valg2 = 1;
            case 2 -> valg2 = 2;
            case 3 -> valg2 = 3;
            case 4 -> valg2 = 4;
            case 5 -> valg2 = 5;
            default -> System.out.println("Ugyldig input");
        }
        listHeader();
        ArrayList<SuperHero> sortedList = new ArrayList<>();
        try{
        sortedList = controller.sortByPrimarySecondary(valg1, valg2);}
        catch (IllegalArgumentException e){
            System.out.println("Du må ikke vælge det samme sorteringskriterie 2 gange.");
        }
        listHeader();
        for (SuperHero hero : sortedList) {
            System.out.println(formatPrint(hero));
        }
    }

    private void sortingMenu() {
        int menuValg = 0;


        System.out.println("Vælg sorteringskriterie\n");
        System.out.println("""
                1. Navn
                2. Heltenavn
                3. Superkraft
                4. Er menneske
                5. Oprindelses år
                6. sorter mellem både primær og sekundær
                9. afslut
                """);
        menuValg = readInt();
        switch (menuValg) {
            case 1 -> sortByNameLocalMethod();
            case 2 -> sortByHeroNameLocalMethod();
            case 3 -> sortByHeroPowerLocalMethod();
            case 4 -> sortByIsHumanLocalMethod();
            case 5 -> sortByYearLocalMethod();
            case 6 -> sortByPrimarySecondaryMethod();
            default -> {
                System.out.println("Ugyldig input");
                sortingMenu();
            }
        }
    }

    private void listHeader() {
        System.out.printf("┃ %-20s │ %-15s │ %-20s │ %-8s │ %-13s ┃ %n", "name", "superheroName", "superheroPower", "Is human", "creationYear");
    }

    private void menuPrint() {
        System.out.println("""
                                    
                Hvad vil du gøre?
                1. Opret superhelt
                2. Vis alle helte
                3. Søg på helte
                4. Rediger helte info
                5. Slet helt
                6. Sorter 
                9. afslut
                """);
    }

    private String formatPrint(SuperHero hero) {
        return String.format("┃ %-20s │ %-15s │ %-20s │ %-8b │ %-13d ┃", hero.getName(), hero.getSuperheroName(),hero.getSuperheroPower(), hero.getIsHuman(), hero.getCreationYear());
    }

    private void takMohamed() {
        System.out.println("""
                                
                THANKS MOHAMED
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣶⣶⣿⣿⣷⣶⣦⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣶⠿⠟⠋⠉⠁⠀⠀⠀⠀⠉⠙⠻⣷⣦⣄⢀⣀⣤⣶⡾⠿⠿⠟⠛⠛⠻⠿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⡛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⡿⠋⠀⠀⠀⠀⢀⣠⣶⣶⣶⣶⣶⣶⣶⣶⣦⣤⣀⠀⢻⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⡟⠁⠀⠀⢠⣴⣿⠟⠛⠉⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⢿⣶⣿⣧⣤⣤⣶⣶⣿⣿⡿⢿⣿⣿⣶⣶⣴⣿⣆⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⡿⠁⠀⠀⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣴⣶⣶⣶⣿⣿⣧⣀⠀⠀⠀⢀⣤⣤⣤⣤⣴⣦⣼⣿⣿⣿⣿⣷⣤⣀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣶⡿⠿⣛⣩⣭⣿⣿⣿⣿⣭⣭⣙⣿⣷⡄⠀⠈⠻⣏⣉⣹⣽⣿⣿⣭⣿⣯⣭⣉⣙⢻⣷⡄⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⡿⠟⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⠿⣟⣩⣷⣶⠿⠟⠋⠉⠉⠁⠀⠉⢉⣉⣉⣛⣿⣿⣶⠾⠿⠿⠛⢛⣉⣍⣭⣉⣍⣉⣉⣛⣻⢿⣿⣇⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣿⣭⣶⡿⠟⠋⠉⠀⠀⢀⣀⣤⣴⣶⣿⣾⣿⠿⠟⠛⠿⣿⣿⣤⣤⣶⣶⡿⠿⢿⣿⣿⣿⣿⣟⠛⠻⠿⢿⣿⣷⡀⠀
                ⠀⠀⠀⠀⠀⠀⢀⣾⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣷⣬⣿⣥⣤⣤⣤⣤⣶⣿⠿⣿⣿⠛⢿⣿⣿⣿⣦⡀⠀⠀⣸⡿⠛⠉⠁⠀⠀⣠⣿⣇⣀⡿⠿⣿⣷⡄⠀⠀⢸⣿⡇⠀
                ⠀⠀⠀⠀⠀⢀⣾⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⣻⣿⣿⣯⣅⡀⠀⢠⣿⣿⠖⢾⣿⡀⣨⣿⣧⣤⣼⣿⣧⣤⣀⣀⠀⢀⣿⣿⡛⣿⣧⣀⣿⣿⣧⣤⣶⣿⠏⠀⠐
                ⠀⠀⠀⠀⣰⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢿⣶⣭⣟⡿⠿⣿⣿⣿⣿⡿⡿⣿⢿⣿⣿⣯⣽⡿⠉⠙⠛⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠟⣿⣿⠿⠃⠀⠀⠀
                ⠀⠀⠀⣰⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠿⠿⠾⠿⠿⠾⠿⠿⣿⣿⣿⡿⠋⠉⠁⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣾⡿⠃⠀⠀⠀⠀⠀
                ⠀⢀⣼⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣴⣾⠿⠋⠁⠀⠀⠀⠀⠻⠿⢿⣶⣶⣶⣶⣶⣶⠾⣿⣿⡋⠉⠀⠀⠀⠀⠀⠀⠀
                ⠀⣼⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⠿⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣦⠀⠀⠀⠈⠻⣷⣄⠀⠀⠀⠀⠀⠀⠀
                ⢸⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠙⢿⣦⠀⠀⠀⠀⠀⠀
                ⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣆⠀⠀⠀⠀⠀
                ⠘⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣿⠿⠿⠿⠿⠿⠿⠿⢿⣷⣶⣦⣤⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣠⣤⣶⣿⠿⠿⢿⣧⠀⠀⠀⠀
                ⠀⢹⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⡏⠉⠀⣤⣤⣤⣤⣤⣄⣀⣀⣀⠉⠉⠉⠛⠛⠿⠿⠿⠶⠶⠶⠶⠶⠶⠾⠿⠿⠿⠟⠛⠛⠉⠉⠁⠀⠀⢀⣼⡿⠀⠀⠀⠀
                ⠀⠈⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠘⣿⣇⠀⠀⠹⠉⠉⠉⡉⠙⠛⠻⠿⢿⣶⣶⣶⣶⣤⣤⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣤⣤⣴⣶⣶⡿⠟⠁⠀⠀⠀⠀
                ⠀⠀⠈⢿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠘⢿⣷⣤⣶⣶⡿⠿⠿⢿⣿⣶⣦⣤⣤⣤⣈⣉⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠉⠉⢈⣿⠆⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠈⠻⣿⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣦⣤⣤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠛⠛⠛⠿⠿⢿⣿⣷⣶⣶⣶⣤⣤⣤⣤⣤⣤⣤⣤⣤⣶⡿⠛⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠈⠻⣿⣷⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣩⣽⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠙⠿⢿⣿⣿⣿⣶⣶⣤⣄⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣠⣶⣾⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠿⢿⣿⣯⣟⣻⣿⠿⠷⠶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⡶⣶⣿⣿⡿⠟⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠻⠿⢷⣶⣶⣶⣶⣶⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣴⣶⣶⡿⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠛⠛⠛⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                """);
    }
}






