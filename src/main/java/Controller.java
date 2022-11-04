import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Controller {

    Database database;
    Filehandler f;

    public Controller() {
        database = new Database();
        f = new Filehandler();
    }

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


