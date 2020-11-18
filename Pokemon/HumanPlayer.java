import java.util.Scanner;

//HumanPlayer concrete class which inherits from Player abstract class
public class HumanPlayer extends Player {

    //var used to check if player chose to run
    private boolean isRun = false;

    //empty default constructor
    public HumanPlayer() {}

    //parametrized super constructor
    public HumanPlayer(Pokemon pokemon, Item item) {

        //from Player
        super(pokemon, item);

    }

    /***
     * Method to display menu options for humanPlayer and act accordingly
     */
    @Override
    public void menu(Pokemon other) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose one of the attacks below:");
        int i = 0;
        //this for each is used to print out the attacks available to the user
        for (Attack att : this.getPokemon().attacks) {
            System.out.println(i + ". " + att.getAttName() + "\t Power Points: " + att.getPp() + " DMG: " + att.getDamage());
            i++;
        }

        //other options
        System.out.println("4. Item");
        System.out.println("5. Run");

        System.out.print("Option: ");
        int attNum = input.nextInt();
        System.out.println("\n");

        //if user chose 4, then use item on pokemon
        if(attNum == 4) {
            System.out.println("Human used an item!\n");
            item.use(this.getPokemon()); //use item
        }
        //if 5 then user forfeits
        else if (attNum == 5) {
            System.out.println("Human has run away!\n");
            this.run(); //run
        } else { //else attack
            this.getPokemon().attack(other, attNum);
        }
    }


    /***
     * method to return isRun
     * @return boolean isRun
     */
    @Override
    public boolean getIsRun() {
        return isRun;
    }

    /***
     * method to specify that this is Human player
     * @return String "Human"
     */
    @Override
    public String getName() {
        return "Human";
    }

    /***
     * method to return Pokemon object
     * @return Pokemon object
     */
    @Override
    public Pokemon getPokemon() {
        return pokemon;
    }

    /***
     * return item to be used
     * @return Item item
     */
    @Override
    public Item getItem() {
        return item;
    }

    /***
     * method to check isRun
     */
    @Override
    public void run() {
        isRun = true;
    }
}
