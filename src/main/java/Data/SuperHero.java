package Data;

import java.util.Scanner;

public class SuperHero {

    private String name;
    private String superheroName;
    private String superheroPower;
    private int creationYear;
    private boolean human;

    public SuperHero(String name, String superheroName, String superheroPower, boolean human, int creationYear) {
        this.name = name;
        this.superheroName = superheroName;
        this.superheroPower = superheroPower;
        this.human = human;
        this.creationYear = creationYear;
    }

    public SuperHero(String name, String superheroPower, boolean human, int creationYear) {
        this.name = name;
        this.superheroPower = superheroPower;
        this.human = human;
        this.creationYear = creationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public String getSuperheroPower() {
        return superheroPower;
    }

    public void setSuperheroPower(String superheroPower) {
        this.superheroPower = superheroPower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    @Override
    public String toString() {
        return
                 name  + "," + superheroName + "," + superheroPower + "," + human + "," + creationYear;
    }
}
