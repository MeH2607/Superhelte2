import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//for nu oprettes superhelte i main, senere vil vi lave en database der holder på data

        Scanner sc = new Scanner(System.in);

        System.out.println("Tilføj en superhelt: ");

        System.out.println("\n Civil navn: ");
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

        System.out.println("Er de et menneske?\nTast 1 for ja\nTast 2 for nej ");
        int valg = sc.nextInt();
        Boolean isHuman = null;
        while (valg != 1 || valg != 2) {
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
        }

        System.out.println("\nHvornår blev de lavet: ");
        int year = sc.nextInt();

        if (heroName == null) {
            SuperHero hero = new SuperHero(name, heroPower,isHuman, year);
            System.out.println("Du har tilføjet " + name + " som ikke har et helte navn\n Deres styrke er "
                    + heroPower );
            if (isHuman = true){
                System.out.println("\nDe er et menneske\nDe blev lavet i år " + year);
            }
            else{
                System.out.println("\nDe er ikke et menneske\nDe blev lavet i år " + year);
            }
        } else {
            SuperHero hero = new SuperHero(name, heroName, heroPower,isHuman, year);
            System.out.println("Du har tilføjet " + name + " også kendt som " + heroName + "\n Deres styrke er "
                    + heroPower );
            if (isHuman = true){
                System.out.println("\nDe er et menneske\nDe blev lavet i år " + year);
            }
            else{
                System.out.println("\nDe er ikke et menneske\nDe blev lavet i år " + year);
            };
        }


    }


}
