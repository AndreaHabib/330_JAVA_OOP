//import Scanner
import java.util.Scanner;

//Bulbasaur concrete class that inherits from Pokemon abstract class
public class Bulbasaur extends Pokemon {

    //default constructor - static stats and attacks
    public Bulbasaur() {
        name = "Bulbasaur"; //name
        type = "Grass"; //type
        hit_points = 100; //total HP
        power_points = 20; //total PP available

        //all the attacks available to a Bulbasaur in a List of Arraylists
        attacks.add(new Attack("Vine Whip", 5, 40));
        attacks.add(new Attack("Seed Bomb", 1, 20));
        attacks.add(new Attack("Power Whip", 3, 30));
        attacks.add(new Attack("Sludge Bomb", 1, 15));
    }

    /***
     * method attack used by specific pokemon to attack other pokemon
     */
    @Override
    public void attack(Pokemon other, int attNum) {

        if (this.power_points - attacks.get(attNum).getPp() >= 0) {
            this.power_points -= attacks.get(attNum).getPp(); //lower pp amount available

            this.speak(); //pokemon speaks

            System.out.println(this.getName() + " used " + attacks.get(attNum).getAttName() + "\n"); //print attack used by pokemon/player

            int damage = bonus(other, attNum) + attacks.get(attNum).getDamage(); //check if type has advantage over other pokemon, increase damage by 0.2%

            //lower other pokemon's health
            other.setHit_points(other.getHit_points() - damage);

        } else {
            //print if user doesn't have enough pp for this attack
            System.out.println(this.getName() + " doesn't have enough power points for this attack!\n");
        }

    }

    /***
     * print out pokemon language
     */
    @Override
    public void speak() {
        System.out.print("Bulb!\n");
    }

    /***
     * calculates the bonus damage depending on both pokemon's types
     * @return int bonus
     */
    @Override
    public int bonus(Pokemon other, int attNum) {

        int bonus = 0;

        //Since Bulbasaur is a Grass type, it is super effective against Ground, Rock and Water
        if(other.getType()  == "Ground" || other.getType() == "Rock" || other.getType() == "Water") {
            bonus = (int)(this.attacks.get(attNum).getDamage() * 0.2); //ratio of 0.2
            System.out.println("It was SUPER EFFECTIVE!");
        }

        return bonus;
    }
}
