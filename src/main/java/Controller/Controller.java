package Controller;

import Data.SuperHero;
import Data.Database;
import Data.Filehandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;

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

    public ArrayList<SuperHero> readFile() {
        return f.readFile();
    }

    public void writeToFile(ArrayList<SuperHero> list) {
        f.writeToFile(list);
    }


    public void initialLoad(){
        database.setHeroDatabase(f.readFile());
    }

    public ArrayList<SuperHero> sortByName(){
        return database.sortByName();
    }

    public ArrayList<SuperHero> sortByHeroName(){
        return database.sortByHeroName();
    }

    public ArrayList<SuperHero> sortByCreationYear(){
        return database.sortByCreationYear();
    }

    public ArrayList<SuperHero> sortByHuman(){
        return database.sortByHuman();
    }

    public ArrayList<SuperHero> sortBySuperHeroPower(){
        return database.sortBySuperHeroPower();
    }

    public ArrayList<SuperHero> sortByPrimarySecondary(){
        return database.sortByPrimarySecondary();
    }



}


