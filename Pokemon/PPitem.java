public class PPitem implements Item {
    private int effect; //amount of health applied to pokemon
    private int amount; //only one item is allowed

    //default constructor - default values for a health potion
    public PPitem() {
        effect = 3;
        amount = 1;
    }

    /***
     * method to use an item on a pokemon
     */
    public void use(Pokemon pokemon) {
        //if 1 item is available
        if(amount == 1) {
            pokemon.setPower_points(effect + pokemon.getPower_points()); //apply the effect to pokemon health
            amount--; //use the item
        }
        else {
            //warn the user that he used all of his items
            System.out.println("All the items have been used!");
        }
    }
}
