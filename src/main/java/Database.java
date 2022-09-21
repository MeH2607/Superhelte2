import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Database {
   // ArrayList<SuperHero> heroDatabase = new ArrayList<>();

  /*  SuperHero s1 = new SuperHero("Clark kent", "Superman", "Super styrke",false,1925);
    SuperHero s2 = new SuperHero("Bruce Wayne", "Batman", "money", true, 1939);
    SuperHero s3 = new SuperHero("Johnny", "Cool as fuck",true, 2000);
    SuperHero s4 = new SuperHero("Saitama", "Super strength", true, 2009);*/

   private ArrayList<SuperHero> heroDatabase = new ArrayList<>(/*Arrays.asList(s1,s2,s3,s4)*/);

   private ArrayList<SuperHero>findSuperheroList = new ArrayList<>();

    Scanner sc;

    public Database() {
        ArrayList<SuperHero> heroDatabase;

    }

    public ArrayList<SuperHero> getHeroDatabase() {
        return heroDatabase;
    }

    public ArrayList<SuperHero> getFindSuperheroList() {
        return findSuperheroList;
    }

    public void addToDatabase(String name, String superheroName, String superheroPower, boolean human, int creationYear) {
            heroDatabase.add(new SuperHero(name, superheroName, superheroPower, human, creationYear));
    }

    public void addToDatabase(String name, String superheroPower, boolean human, int creationYear) {
            heroDatabase.add(new SuperHero(name, superheroPower, human, creationYear));
    }


    public SuperHero searchForHero(String searchName){
        findSuperheroList = new ArrayList<>();
        for (SuperHero hero : heroDatabase){
            //to if løkker hvis man vil søge via superheltenavn og almindelig navn
            if(hero.getName().toLowerCase().contains(searchName.toLowerCase())){
                return hero;
            }
            //Første del i tilfælde af at superheroName er null og så ikke prøver at gøre null lowercase og crash
            else if(hero.getSuperheroName() != null && hero.getSuperheroName().contains(searchName.toLowerCase())){
                return hero;
            }
        }
        System.out.println("Kunne ikke finde " + searchName);
        return null;
    }

    //Samler en gruppe af helte, når man skal gemme resultater. Bruges til når der skal redigeres.
    public ArrayList<SuperHero> searchForHeroList(String searchName){
        //for (SuperHero hero : heroDatabase){
        SuperHero hero;
        //Clear for at når man søger flere gange så gemmes de gamle svar ikke
        findSuperheroList.clear();
        for (int n = 0; n<heroDatabase.size(); n++){
            hero = heroDatabase.get(n);
            if(hero.getName().toLowerCase().contains(searchName.toLowerCase())){
                findSuperheroList.add(hero);

            }
            else if(hero.getSuperheroName() != null && hero.getSuperheroName().contains(searchName.toLowerCase())){
                findSuperheroList.add(hero);
            }
        }
        return findSuperheroList;
    }

    public void deleteHero(int heroToDelete){
        int deleteOnIndex = heroToDelete - 1;
        System.out.println(heroDatabase.get(deleteOnIndex).getName() + " has been deleted");
        heroDatabase.remove(deleteOnIndex);
    }

}




