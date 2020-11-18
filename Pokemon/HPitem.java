//Item class (health potion) Implements Item interface
public class HPitem implements Item {

    private int effect; //amount of health applied to pokemon
    private int amount; //only one item is allowed

    //default constructor - default values for a health potion
    public HPitem() {
        effect = 20;
        amount = 1;
    }

    /***
     * method to use an item on a pokemon
     */
    public void use(Pokemon pokemon) {
        //if 1 item is available
        if(amount == 1) {
            pokemon.setHit_points(effect + pokemon.getHit_points()); //apply the effect to pokemon health
            amount--; //use the item
        }
        else {
            //warn the user that he used all of his items
            System.out.println("All the items have been used!");
        }
    }

}
