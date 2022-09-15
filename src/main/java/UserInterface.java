import javax.xml.crypto.Data;
import java.util.Scanner;

public class UserInterface {

    private Database database;
    Scanner sc;

    public void startProgram() {
        int menuValg;

        System.out.println("Velkommen til Superhelte databasen\n");
        do {
            System.out.println("""
                    Hvad vil du gøre?
                    1. Opret superhelt
                    2. Vis alle helte
                    3. Søg på helte
                    9. afslut
                    """);
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

    /*
    public void searchOfHero(String searchName){
        Boolean find = false;
        for (SuperHero hero : heroDatabase){
            if(hero.getName().toLowerCase().contains(searchName.toLowerCase())){
                System.out.println("Civilnavn : " + hero.getName());
                if(hero.getSuperheroName() == null){
                    System.out.println("\nIntet heltenavn");
                }
                else{
                    System.out.println("Superheltenavn: " + hero.getSuperheroName());
                }
                if (hero.isHuman() == true) {
                    System.out.println("\nMenneske?: Ja");
                } else {
                    System.out.println("\nMenneske?: Nej");
                }
                System.out.println("\nSuperstyrke: " + hero.getSuperheroPower());
                System.out.println("\nOprindelsesår: " + hero.getCreationYear() + "\n");
                find = true;
            }
            else if(hero.getSuperheroName() != null && hero.getSuperheroName().contains(searchName.toLowerCase())){
                System.out.println("Civilnavn : " + hero.getName());
                if(hero.getSuperheroName() == null){
                    System.out.println("\nIntet heltenavn");
                }
                else{
                    System.out.println("Superheltenavn: " + hero.getSuperheroName());
                }
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
     */

