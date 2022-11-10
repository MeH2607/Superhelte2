package domain;
public class SuperHero{

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

    public boolean getIsHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }


    public String PrintSuperHeroName() {
        String s;
        if (superheroName == null) {
            return "* Har ikke superheltenavn *";
        } else {
            return superheroName;
        }
    }


    @Override
    public String toString() {
        return String.format("┃ %-20s │ %-15s │ %-20s │ %-8b │ %-13d ┃", name, superheroName, superheroPower, human, creationYear);
                // "[" + "Civil navn: " +  name  + ", " + "Superheltenavn: " + superheroName + ", " + "Superheltekraft: " + superheroPower + ", " + "Er menneske: " + human + ", " + "Oprindelses år: " + creationYear + "] ";
    }

}