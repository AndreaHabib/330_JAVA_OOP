//Attack class
/***
 * Attack class holds the information and stats of each attack in the ArrayList
 */
public class Attack {

    private String attName; //attack name
    private int pp; //power points of this attack
    private int damage; //damage of this attack

    //default constructor
    public Attack() {

        attName = "";
        pp = 0;
        damage = 0;

    }

    //parametrized constructor
    public Attack(String attName, int pp, int damage) {

        this.attName = attName;
        this.pp = pp;
        this.damage = damage;

    }

    //accessors and mutators
    public void setAttName(String attName) {
        this.attName = attName;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPp() {
        return pp;
    }

    public String getAttName() {
        return attName;
    }

    public int getDamage() {
        return damage;
    }
}
