import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//for nu oprettes superhelte i main, senere vil vi lave en database der holder på data


        //TODO lav en menu der opretter en superhelt eller lukker programmet. Loop kommer senere
        Scanner sc = new Scanner(System.in);

        Database database = new Database();

        int menuValg;

        System.out.println("Velkommen til Superhelte databasen\n");
        do {
            System.out.println("Hvad vil du gøre?\n1. Opret superhelt\n9. afslut");
            menuValg = sc.nextInt();
            //Nextline for at forhindre scanner bug
            sc.nextLine();
            switch (menuValg) {
                case 1:
                    database.createAndAddHero();
                    System.out.println(database.getHeroDatabase().size());
                    break;
                case 2:
                    for(SuperHero heroes : database.getHeroDatabase())
                        System.out.println("Civilnavn : " + heroes.getName() + "\nHeltenavn: " + heroes.getSuperheroName()
                        + "\n");
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
}
