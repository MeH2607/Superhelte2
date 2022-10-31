import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Controller {

    Database database = new Database();



    public void createAndAddHero(String name, String heroName, String heroPower, boolean isHuman, int year) {
        database.addToDatabase(name, heroName, heroPower, isHuman, year);
    }

    public void createAndAddHero(String name, String heroPower, boolean isHuman, int year) {
        database.addToDatabase(name, heroPower, isHuman, year);
    }

    public ArrayList<SuperHero> getHeroDatabase(){
        return database.getHeroDatabase();
    }

    public ArrayList<SuperHero> searchForHeroList(String searchName){

        return database.searchForHeroList(searchName);
    }

    public void deleteHero(int heroToDelete){
        database.deleteHero(heroToDelete);
    }

}


