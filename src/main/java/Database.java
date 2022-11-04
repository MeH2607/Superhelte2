import java.util.ArrayList;

public class Database {

    private ArrayList<SuperHero> heroDatabase = new ArrayList<>();
    private ArrayList<SuperHero> findSuperheroList = new ArrayList<>();


    public ArrayList<SuperHero> getHeroDatabase() {
        return heroDatabase;
    }

    public void setHeroDatabase(ArrayList<SuperHero> heroDatabase) {
        this.heroDatabase = heroDatabase;
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
    //Samler en gruppe af helte, når man skal gemme resultater. Bruges til når der skal redigeres.
    public ArrayList<SuperHero> searchForHeroList(String searchName) {
        SuperHero hero;
        findSuperheroList.clear(); //Clear for at når man søger flere gange så gemmes de gamle svar ikke

        for (int n = 0; n < heroDatabase.size(); n++) {
            hero = heroDatabase.get(n);
            if (hero.getName().toLowerCase().contains(searchName.toLowerCase())) {
                findSuperheroList.add(hero);

            } else if (hero.getSuperheroName() != null && hero.getSuperheroName().contains(searchName.toLowerCase())) {
                findSuperheroList.add(hero);
            }
        }
        return findSuperheroList;
    }

    public void deleteHero(int heroToDelete) {

        //Fjerner 1 fra bruger input for at matche arraylist index
        int deleteOnIndex = heroToDelete - 1;

        //Printer ud før der slettes så man stadig kan hente den slettede helts navn.
        System.out.println(heroDatabase.get(deleteOnIndex).getName() + " has been deleted");

        heroDatabase.remove(deleteOnIndex);
    }

}




