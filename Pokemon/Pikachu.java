//import Scanner
import java.util.Scanner;

//Pikachu concrete class that inherits from Pokemon abstract class
public class Pikachu extends Pokemon{

    //default constructor - static stats and attacks
    public Pikachu() {
        name = "Pikachu"; //name
        type = "Electric"; //type
        hit_points = 100; //total HP
        power_points = 20; //total PP available

        //all the attacks available to a Bulbasaur in a List of Arraylists
        attacks.add(new Attack("Thunder Shock", 1, 25));
        attacks.add(new Attack("Wild Charge", 5, 40));
        attacks.add(new Attack("Thunderbolt", 1, 15));
        attacks.add(new Attack("Discharge", 3, 30));
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
        System.out.print("Pika!\n");
    }

    /***
     * calculates the bonus damage depending on both pokemon's types
     * @return int bonus
     */
    @Override
    public int bonus(Pokemon other, int attNum) {

        int bonus = 0;

        //Since Pikachu is a Electric type, it is super effective against Flying and Water
        if(other.getType()  == "Flying" || other.getType() == "Water") {
            bonus = (int)(this.attacks.get(attNum).getDamage() * 0.2);
            System.out.println("It was SUPER EFFECTIVE!");
        }

        return bonus;
    }

}
