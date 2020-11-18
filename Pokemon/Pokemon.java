//import Arraylist and List to be used
import java.util.ArrayList;
import java.util.List;

//Pokemon abstract class
public abstract class Pokemon {

    //all variables within Pokemon
    protected int hit_points; //HP
    protected int power_points;
    protected String name;
    protected String type;
    protected List<Attack> attacks = new ArrayList<>(); //List of attacks

    public abstract void attack(Pokemon other, int attNum); //abstract method attack used by specific pokemon to attack other pokemon
    public abstract void speak(); //abstract method for pokemon to speak specific language of the pokemon
    public abstract int bonus(Pokemon other, int attNum);

    //default constructor
    public Pokemon() {
        hit_points = 0;
        power_points = 0;
        name = "";
        type = "";
    }

    //parameterized constructor
    public Pokemon(int hit_points, int power_points, String name, String type) {
        this.hit_points = hit_points;
        this.power_points = power_points;
        this.name = name;
        this.type = type;
    }

    //accessors and mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public void setPower_points(int power_points) {
        this.power_points = power_points;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getHit_points() {
        return hit_points;
    }

    public int getPower_points() {
        return power_points;
    }

    public String getType() {
        return type;
    }
}
