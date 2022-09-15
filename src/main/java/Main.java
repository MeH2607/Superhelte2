import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//for nu oprettes superhelte i main, senere vil vi lave en database der holder på data


        Scanner sc = new Scanner(System.in);

        Database database = new Database();

        int menuValg;

        System.out.println("Velkommen til Superhelte databasen\n");
        do {
            System.out.println("Hvad vil du gøre?\n1. Opret superhelt\n2. Vis alle helte\n3. Søg på helte\n9. afslut");
            menuValg = sc.nextInt();
            sc.nextLine();
            switch (menuValg) {
                case 1:
                    database.createAndAddHero();
                    break;
                case 2:
                    for (SuperHero heroes : database.getHeroDatabase()) {
                        System.out.println("Civilnavn : " + heroes.getName());
                        if (heroes.getSuperheroName() == null) {
                            System.out.println("\nIntet heltenavn");
                        } else {
                            System.out.println("Superheltenavn: " + heroes.getSuperheroName());
                        }
                        if (heroes.isHuman() == true) {
                            System.out.println("\nMenneske?: Ja");
                        } else {
                            System.out.println("\nMenneske?: Nej");
                        }
                        System.out.println("\nSuperstyrke: " + heroes.getSuperheroPower());
                        System.out.println("\nOprindelsesår: " + heroes.getCreationYear() + "\n\n");
                    }
                    break;
                case 3:
                    System.out.println("Søg på et helts civil navn: ");
                    String searchName = sc.nextLine();
                    database.searchForHero(searchName);
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
}
