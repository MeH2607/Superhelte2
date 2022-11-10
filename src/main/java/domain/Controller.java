package domain;

import dataSource.Filehandler;

import java.util.ArrayList;

public class Controller {

    Database database;
    Filehandler f;

    public Controller() {
        database = new Database();
        f = new Filehandler();
    }

    public void createHero(String name, String heroName, String heroPower, boolean isHuman, int year) {
        database.addToDatabase(name, heroName, heroPower, isHuman, year);
        f.writeToFile(database.getHeroDatabase());
    }

    public ArrayList<SuperHero> getHeroDatabase(){
        return database.getHeroDatabase();
    }

    public ArrayList<SuperHero> searchForHeroList(String searchName){

        return database.searchForHeroList(searchName);
    }

    public void deleteHero(int heroToDelete){
        database.deleteHero(heroToDelete);
        f.writeToFile(database.getHeroDatabase());
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

    public ArrayList<SuperHero> sortByPrimarySecondary(int valg1, int valg2){
        return database.sortByPrimarySecondary(valg1, valg2);
    }

}


