import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//for nu oprettes superhelte i main, senere vil vi lave en database der holder på data

        //TODO lav en menu der opretter en superhelt eller lukker programmet. Loop kommer senere
       Scanner sc = new Scanner(System.in);

        Database database = new Database();

        int menuValg;

        System.out.println("Velkommen til Superhelte databasen\n\n1. Opret superhelt\n9. afslut");
        menuValg = sc.nextInt();
        switch (menuValg){
            case 1:
                database.createAndAddHero();
                break;
            case 9:
                System.out.println("Op gensyn");
                break;
            default:
                System.out.println("Ugyldigt valg");
        }

    }
}
