//ComputerPlayer concrete class which inherits from Player abstract class
public class ComputerPlayer extends Player{

    //var used to check if player chose to run
    private boolean isRun = false;

    //empty default constructor
    public ComputerPlayer() {}

    //parametrized super constructor
    public ComputerPlayer(Pokemon pokemon, Item item) {

        //from Player
        super(pokemon, item);

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
     * @return String "Computer"
     */
    @Override
    public String getName() {
        return "Computer";
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

    /***
     * Computer algorithm: 1/3 chance to run, can use item, and attack other pokemon from 0 to 3
     */
    @Override
    public void menu(Pokemon other) {
        //var used to check if the computer forfeits
        int chanceToRun = 0;

        //give computer 1/3 chance to run
        if(this.getPokemon().getHit_points() > 20) {
            chanceToRun = ((int)(Math.random() * (2 - 0)) + 0);
        }

        int attNum = 0;

        //2 indicates computer will run
        if(chanceToRun == 2) {
            this.run();
        }
        else {
            //give the computer a random number from 0 to 4
            attNum = ((int) (Math.random() * (4 - 0)) + 0);

            //computer uses an item
            if (attNum == 4) {
                System.out.println("Computer used an item!");
                item.use(this.getPokemon());
            } else {
                this.getPokemon().attack(other, attNum);
            }
        }
    }
}

