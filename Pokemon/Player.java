import java.util.Scanner;

//Player abstract class
public abstract class Player {

    //all variables within Pokemon
    protected Pokemon pokemon;
    protected Item item;

    //default constructor
    //Note: Default constructor in this class is especially required to allow player to choose pokemon. Refer to PokemonRunner.java.
    public Player() {
        pokemon = null;
        item = null;
    }

    //parameterized constructor
    public Player(Pokemon pokemon, Item item) {
        this.pokemon = pokemon;
        this.item = item;
    }

    public abstract void menu(Pokemon other);
    public abstract String getName(); //Get name of player - Specifies if Human or Computer
    public abstract Pokemon getPokemon(); //Get pokemon Object
    public abstract Item getItem(); //Get item to be used
    public abstract void run(); //Run - forfeit the match
    public abstract boolean getIsRun(); //Check if user chose to Run

    //Method used to check whose the winner
    public boolean isWin(Player other) {

        //checks if player's pokemon's health is below 0 or chose to run
        if(this.getPokemon().getHit_points() <= 0 || this.getIsRun()) {
            System.out.println(this.getPokemon().getName() + " has fainted!\n");
            System.out.println(other.getName() + " is the winner!");
            return true;
        }

        //checks if other player's pokemon's health is below 0 or chose to run
        else if(other.getPokemon().getHit_points() <= 0 || this.getIsRun()) {
            System.out.println(other.getPokemon().getName() + " has fainted!\n");
            System.out.println(this.getName() + " is the winner!");
            return true;
        }
        return false; //if none return false
    }

    //print out stats using toString
    public String toString() {
        String s = "HP: " + this.getPokemon().getHit_points() + "\n";
        s += "PP: " + this.getPokemon().getPower_points() + "\n";

        return s;
    }

}
